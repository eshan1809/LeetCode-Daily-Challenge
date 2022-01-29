class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for(int g = 0; g < n; g++){
            for(int i = 0, j = g; j < n; i++, j++){
                int prod = (i == 0 ? 1 : nums[i - 1]) * (j == n - 1 ? 1 : nums[j + 1]);
                if(g == 0){
                    dp[i][j] = nums[i] * prod;
                } else{
                    int max = 0;
                    for(int r = i; r <= j; r++){
                        int left = (r == i ? 0 : dp[i][r - 1]), right = (r == j ? 0 : dp[r + 1][j]);
                        max = Math.max(max, nums[r] * prod + left + right);
                    }
                    dp[i][j] = max;
                }
            }
        }
        return dp[0][n - 1];
    }
}
