class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();
        for(int[] e : times)
            graph[e[0] - 1].add(new int[]{e[1] - 1, e[2]});
        
        int[] time = new int[n];
        Arrays.fill(time, -1);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{k - 1, 0});
        
        while(!pq.isEmpty()){
            int[] rem = pq.remove();
            if(time[rem[0]] != -1)
                continue;
            time[rem[0]] = rem[1];
            for(int[] nbr : graph[rem[0]])
                pq.add(new int[]{nbr[0], nbr[1] + rem[1]});
        }
        
        int ans = 0;
        for(int i : time){
            if(i == -1)
                return -1;
            ans = Math.max(ans, i);
        }
        return ans;
    }
}
