class Solution {
    public int threeSumMulti(int[] arr, int target) {
        return helper(arr, 0, 0, 0, target, new Integer[arr.length][3][300]);
    }
    
    private int helper(int[] nums, int idx, int pick, int sum, int target, Integer[][][] dp){
        if(pick == 3){
            if(sum == target)
                return 1;
            return 0;
        }
        if(sum > target || idx == nums.length)
            return 0;
        if(dp[idx][pick][sum] != null)
            return dp[idx][pick][sum];
        
        int ans = (helper(nums, idx + 1, pick + 1, sum + nums[idx], target, dp) + helper(nums, idx + 1, pick, sum, target, dp)) % (int)(1e9+7);
        return dp[idx][pick][sum] = ans;
    }
}
