class Solution {
    public int maximumScore(int[] nums, int[] multipliers) {
        return helper(0, multipliers, 0, nums, new Integer[multipliers.length][multipliers.length]);
    }
    
    private int helper(int i, int[] multipliers, int lo, int[] nums, Integer[][] dp){
        int hi = lo + nums.length - i - 1;
        if(lo > hi || i == multipliers.length){
            return 0;
        }
        if(dp[lo][i] != null)
            return dp[lo][i];
        int f1 = nums[lo] * multipliers[i] + helper(i + 1, multipliers, lo + 1, nums, dp);
        int f2 = nums[hi] * multipliers[i] + helper(i + 1, multipliers, lo, nums, dp);
        dp[lo][i] = Math.max(f1, f2);
        return dp[lo][i];
    }
}
