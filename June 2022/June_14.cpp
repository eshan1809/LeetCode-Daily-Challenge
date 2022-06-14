class Solution {
public:
    int minDistance(string word1, string word2) {
        int n = word1.length(), m = word2.length();
        int dp[n + 1][m + 1];
        for(int i = 0; i <= n; i++)
            dp[i][0] = i;
        for(int i = 1; i <= m; i++)
            dp[0][i] = i;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                int x = min(dp[i - 1][j], dp[i][j - 1]);
                if(word1[i - 1] == word2[j - 1])
                    dp[i][j] = min(dp[i - 1][j - 1], x + 1);
                else
                    dp[i][j] = min(dp[i - 1][j - 1] + 2, x + 1);
            }
        }
        return dp[n][m];
    }
};
