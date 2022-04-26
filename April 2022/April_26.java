class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<int[]>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++)
                graph[i] = new ArrayList<>();
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                int dist = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                graph[i].add(new int[]{j, dist});
                graph[j].add(new int[]{i, dist});
            }
        }
        
        boolean[] vis = new boolean[n];
        int cost = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{0, 0});
        while(!pq.isEmpty()){
            int[] rem = pq.remove();
            if(vis[rem[0]])
                continue;
            vis[rem[0]] = true;
            cost += rem[1];
            for(int[] nbr : graph[rem[0]])
                if(!vis[nbr[0]])
                    pq.add(nbr);
        }
        
        return cost;
    }
}
