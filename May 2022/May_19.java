class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        
        Queue<int[]> q = new ArrayDeque<>();
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                q.add(new int[]{i, j});
        
        int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        int[][] dp = new int[n][m];
        int t = 1;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                int[] rem = q.remove();
                if(dp[rem[0]][rem[1]] >= t)
                    continue;
                dp[rem[0]][rem[1]] = t;
                
                for(int[] d : dirs){
                    int x = rem[0] + d[0], y = rem[1] + d[1];
                    if(x >= 0 && y >= 0 && x < n && y < m && matrix[x][y] > matrix[rem[0]][rem[1]])
                        q.add(new int[]{x, y});
                }
            }
            t++;
        }
        return t - 1;
    }
}
