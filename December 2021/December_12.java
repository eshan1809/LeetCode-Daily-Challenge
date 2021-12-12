class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length, sum = 0;
        for(int i = 0; i < n; i++)
            sum += nums[i];
        if(sum % 2 == 1)
            return false;
        return subsetSum(nums, sum / 2);
    }
    
    private boolean subsetSum(int[] nums, int sum){
        int n = nums.length;
        boolean[][] dp = new boolean[sum + 1][n + 1];
        for(int i = 0; i <= n; i++)
            dp[0][i] = true;
        for(int i = 1; i <= sum; i++)
            dp[i][0] = false;
        for(int i = 1; i <= sum; i++){
            for(int j = 1; j <= n; j++){
                dp[i][j] = dp[i][j - 1];
                if(i >= nums[j - 1] && dp[i - nums[j - 1]][j - 1])
                    dp[i][j] = true;
            }
        }
        return dp[sum][n];
    }
}
