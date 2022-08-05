class Solution {
    public int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        Integer[][] dp = new Integer[n][target + 1];
        return helper(nums, 0, target, dp);
    }
    
    private int helper(int[] nums, int id, int target, Integer[][] dp){
        if(target < 0)
            return 0;
        if(id == nums.length){
            if(target == 0)
                return 1;
            return 0;
        }
        if(dp[id][target] != null)
            return dp[id][target];
        int ans = helper(nums, 0, target - nums[id], dp) + helper(nums, id + 1, target, dp);
        return dp[id][target] = ans;
    }
}
