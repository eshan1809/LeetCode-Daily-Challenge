 class Solution {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length + 1, m = matrix[0].length + 1, ans = 0;
        int[][] dp = new int[n][m];
        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                if(matrix[i - 1][j - 1] == '1')
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans * ans;
    }
}
