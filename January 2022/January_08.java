class Solution {
    private int helper(int[][] grid, int r, int c1, int c2, int n, int m, Integer[][][] dp){
        if(c1 < 0 || c1 >= m || c2 < 0 || c2 >= m || r >= n || c1 > c2)
            return 0;
        
        if(dp[r][c1][c2] != null)
            return dp[r][c1][c2];
        
        int cherries = 0;
        if(c1 == c2)
            cherries = grid[r][c1];
        else
            cherries = grid[r][c1] + grid[r][c2];
        
        int ans = helper(grid, r + 1, c1 - 1, c2 - 1, n, m, dp);
        ans = Math.max(ans, helper(grid, r + 1, c1 - 1, c2, n, m, dp));
        ans = Math.max(ans, helper(grid, r + 1, c1 - 1, c2 + 1, n, m, dp));
        ans = Math.max(ans, helper(grid, r + 1, c1, c2 - 1, n, m, dp));
        ans = Math.max(ans, helper(grid, r + 1, c1, c2, n, m, dp));
        ans = Math.max(ans, helper(grid, r + 1, c1, c2 + 1, n, m, dp));
        ans = Math.max(ans, helper(grid, r + 1, c1 + 1, c2 - 1, n, m, dp));
        ans = Math.max(ans, helper(grid, r + 1, c1 + 1, c2, n, m, dp));
        ans = Math.max(ans, helper(grid, r + 1, c1 + 1, c2 + 1, n, m, dp));
        
        dp[r][c1][c2] = cherries + ans;
        return cherries + ans;
    }
    
    public int cherryPickup(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        return helper(grid, 0, 0, m - 1, n , m, new Integer[n][m][m]);
    }
}
