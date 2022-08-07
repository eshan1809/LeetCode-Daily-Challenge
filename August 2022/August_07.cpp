class Solution {
public:
    int countVowelPermutation(int n) {
        int mod = (int)(1e9 + 7);
        long dp[n][5];
        dp[n - 1][0] = dp[n - 1][1] = dp[n - 1][2] = dp[n - 1][3] = dp[n - 1][4] = 1ll;
        for(int i = n - 2; i >= 0; i--){
            dp[i][0] = dp[i + 1][1];
            dp[i][1] = (dp[i + 1][0] + dp[i + 1][2]) % mod;
            dp[i][2] = (dp[i + 1][0] + dp[i + 1][1] + dp[i + 1][3] + dp[i + 1][4]) % mod;
            dp[i][3] = (dp[i + 1][2] + dp[i + 1][4]) % mod;
            dp[i][4] = dp[i + 1][0];
        }
        return (int)((dp[0][0] + dp[0][1] + dp[0][2] + dp[0][3] + dp[0][4]) % mod);
    }
};
