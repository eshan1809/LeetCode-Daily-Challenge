class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        boolean[] vis = new boolean[n];
        int[] grp = new int[n];
        for(int i = 0; i < n; i++){
            if(vis[i])
                continue;
            Queue<Integer> q = new ArrayDeque<>();
            q.add(i);
            int g = 0;
            while(!q.isEmpty()){
                int size = q.size();
                while(size-- > 0){
                    int rem = q.remove();
                    if(vis[rem]){
                        if(grp[rem] == g)
                            continue;
                        return false;
                    }
                    vis[rem] = true;
                    grp[rem] = g;
                    
                    for(int nbr : graph[rem])
                        q.add(nbr);
                }
                g = 1 - g;
            }
        }
        return true;
    }
}
