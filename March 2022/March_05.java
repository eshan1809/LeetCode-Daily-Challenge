class Solution {
    public int deleteAndEarn(int[] nums) {
        int n = (int)1e4 + 2;
        int[] arr = new int[n];
        for(int i : nums)
            arr[i] += i;
        
        int[][] dp = new int[2][n];
        for(int i = 1; i < n - 1; i++){
            dp[0][i] = Math.max(dp[0][i - 1], dp[1][i - 1] + arr[i]);
            dp[1][i] = Math.max(dp[0][i - 1], dp[1][i - 1]);
        }
        return Math.max(dp[0][n - 2], dp[1][n - 2]);
    }
}
