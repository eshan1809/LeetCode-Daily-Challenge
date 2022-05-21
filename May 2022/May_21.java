class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        dp = new Integer[amount + 1][coins.length];
        int ans = helper(coins, amount, coins.length - 1);
        return ans >= 100 ? -1 : ans;
    }
    
    Integer[][] dp;
    
    private int helper(int[] coins, int amount, int i){
        if(amount == 0)
            return 0;
        if(amount < 0 || i < 0)
            return 100;
        if(dp[amount][i] != null)
            return dp[amount][i];
        return dp[amount][i] = Math.min(1 + helper(coins, amount - coins[i], i), helper(coins, amount, i - 1));
    }
}
