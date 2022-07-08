class Solution {
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        dp = new Integer[target + 1][n + 1][m + 1];
        int ans = helper(houses, cost, m, n, target, 0, 0);
        return ans == MAX ? -1 : ans;
    }
    
    Integer[][][] dp;
    int MAX = (int)(1e9);
    
    private int helper(int[] houses, int[][] cost, int m, int n, int target, int prev, int idx){
        if(target < 0)
            return MAX;
        if(idx == m){
            if(target == 0)
                return 0;
            return MAX;
        }
        if(dp[target][prev][idx] != null)
            return dp[target][prev][idx];
        if(houses[idx] != 0){
            if(houses[idx] == prev)
                return dp[target][prev][idx] = helper(houses, cost, m, n, target, prev, idx + 1);
            return dp[target][prev][idx] = helper(houses, cost, m, n, target - 1, houses[idx], idx + 1);
        }
        int ans = MAX;
        for(int i = 1; i <= n; i++){
            if(i == prev)
                ans = Math.min(ans, cost[idx][i - 1] + helper(houses, cost, m, n, target, i, idx + 1));
            else
                ans = Math.min(ans, cost[idx][i - 1] + helper(houses, cost, m, n, target - 1, i, idx + 1));
        }
        return dp[target][prev][idx] = ans;
    }
}
