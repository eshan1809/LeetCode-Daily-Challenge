class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int n = costs.length;
        return helper(costs, n, 0, 0, 0, new Integer[n][n / 2 + 1][n / 2 + 1]);
    }
    
    private int helper(int[][] costs, int n, int idx, int a, int b, Integer[][][] dp){
        if(a > n / 2 || b > costs.length / 2)
            return 1000000;
        if(idx == costs.length)
            return 0;
        if(dp[idx][a][b] != null)
            return dp[idx][a][b];
        return dp[idx][a][b] = Math.min(costs[idx][0] + helper(costs, n, idx + 1, a + 1, b, dp), costs[idx][1] + helper(costs, n, idx + 1, a, b + 1, dp));
    }
}
