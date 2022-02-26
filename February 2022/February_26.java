class Solution {
    public int shortestPathLength(int[][] graph) {
        int n =  graph.length;
        int visAll = (1 << n) - 1;
        boolean[][] visited = new boolean[n][visAll + 1];
        
        Queue<int[]> q = new ArrayDeque<>();
        for(int i = 0; i < n; i++)
            q.add(new int[]{i, 1 << i});
        
        int pathLen = 0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                int[] rem = q.remove();
                if(rem[1] == visAll)
                    return pathLen;
                
                if(visited[rem[0]][rem[1]])
                    continue;
                visited[rem[0]][rem[1]] = true;
                
                for(int nbr : graph[rem[0]]){
                    int mask = rem[1] | (1 << nbr);
                    if(!visited[nbr][mask])
                        q.add(new int[]{nbr, mask});
                }
            }
            pathLen++;
        }
        return pathLen;
    }
}
