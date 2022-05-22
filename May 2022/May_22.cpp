class Solution {
public:
    int countSubstrings(string s) {
        int n = s.length(), count = 0;
        bool dp[n][n];
        for(int k = 0; k < n; k++){
            for(int i = 0, j = k; j < n; i++, j++){
                if(k == 0)
                    dp[i][j] = true;
                else if(k == 1)
                    dp[i][j] = (s[i] == s[j]);
                else
                    dp[i][j] = ((s[i] == s[j]) && dp[i + 1][j - 1]);
                if(dp[i][j])
                    count++;
            }
        }
        return count;
    }
};
