class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length, m = heights[0].length;
        boolean[][] vis = new boolean[n][m];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.add(new int[]{0, 0, 0});
        while(!pq.isEmpty()){
            int[] rem = pq.remove();
            if(vis[rem[0]][rem[1]])
                continue;
            vis[rem[0]][rem[1]] = true;
            if(rem[0] == n - 1 && rem[1] == m - 1)
                return rem[2];
            
            if(rem[0] > 0)
                pq.add(new int[]{rem[0] - 1, rem[1], Math.max(rem[2], Math.abs(heights[rem[0]][rem[1]] - heights[rem[0] - 1][rem[1]]))});
            if(rem[1] > 0)
                pq.add(new int[]{rem[0], rem[1] - 1, Math.max(rem[2], Math.abs(heights[rem[0]][rem[1]] - heights[rem[0]][rem[1] - 1]))});
            if(rem[0] + 1 < n)
                pq.add(new int[]{rem[0] + 1, rem[1], Math.max(rem[2], Math.abs(heights[rem[0]][rem[1]] - heights[rem[0] + 1][rem[1]]))});
            if(rem[1] + 1 < m)
                pq.add(new int[]{rem[0], rem[1] + 1, Math.max(rem[2], Math.abs(heights[rem[0]][rem[1]] - heights[rem[0]][rem[1] + 1]))});
        }
        return 0;
    }
}
