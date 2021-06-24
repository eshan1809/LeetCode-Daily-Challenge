class Solution {
    public int helper(int m, int n, int move, int row, int col, Integer[][][] dp){
        if(row < 0 || row >= m || col < 0 || col >= n)
            return 1;
      
        if(dp[row][col][move] != null)
            return dp[row][col][move];
        
        if(move == 0)
            return 0;
        
        int ans = 0;
        ans = (ans + helper(m, n, move - 1, row + 1, col, dp)) % 1000000007;
        ans = (ans + helper(m, n, move - 1, row - 1, col, dp)) % 1000000007;
        ans = (ans + helper(m, n, move - 1, row, col + 1, dp)) % 1000000007;
        ans = (ans + helper(m, n, move - 1, row, col - 1, dp)) % 1000000007;
        
        dp[row][col][move] = ans;
        return ans;
    }
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        return (helper(m, n, maxMove, startRow, startColumn, new Integer[m][n][maxMove + 1]));
    }
}
