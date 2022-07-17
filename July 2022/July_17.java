class Solution {
    public int kInversePairs(int n, int k) {
        int[][] dp = new int[n + 1][k + 1];
        int mod = (int)(1e9 + 7);
        for(int i = 1; i <= n; i++){
            dp[i][0] = 1;
            for(int j = 1; j <= k; j++){
                int val = (dp[i - 1][j] - (j - i >= 0 ? dp[i - 1][j - i] : 0) + mod) % mod;
                dp[i][j] = (dp[i][j - 1] + val) % mod;;
            }
        }
        return (dp[n][k] - (k > 0 ? dp[n][k - 1] : 0) + mod) % mod;
    }
}
