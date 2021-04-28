class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        if(obstacleGrid[n-1][m-1] == 1) return 0;
        int[][] dp = new int[n][m];
        dp[n-1][m-1] = 1;
        for(int i = n - 2; i >= 0; i--) dp[i][m-1] = obstacleGrid[i][m-1] == 1 ? 0 : dp[i+1][m-1];
        for(int j = m - 2; j >= 0; j--) dp[n-1][j] = obstacleGrid[n-1][j] == 1 ? 0 : dp[n-1][j+1];
        for(int i = n - 2; i >= 0; i--){
            for(int j = m - 2; j >= 0; j--){
                dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : dp[i+1][j] + dp[i][j+1];
            }
        }
        return dp[0][0];
    }
}
