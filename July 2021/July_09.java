class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int lis = 0;
        for(int i = 0; i < dp.length; i++){
            int max = 0;
            for(int j = 0; j < i; j++)
                if(nums[j] < nums[i]) max = Math.max(max, dp[j]);
            dp[i] = max + 1;
            lis = Math.max(lis, max + 1);
        }
        return lis;
    }
}
