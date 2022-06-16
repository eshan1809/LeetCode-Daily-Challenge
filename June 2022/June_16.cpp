class Solution {
public:
    string longestPalindrome(string s) {
        int n = s.length(), lb = 0, le = 0;
        bool dp[n][n];
        for(int g = 0; g < n; g++)
            for(int i = 0, j = g; j < n; i++, j++){
                if(g == 0)
                    dp[i][j] = true;
                else if(g == 1)
                    dp[i][j] = (s[i] == s[j]);
                else
                    dp[i][j] = (s[i] == s[j] && dp[i + 1][j - 1]);
                if(dp[i][j])
                    lb = i, le = j;
            }
        return s.substr(lb, le - lb + 1);
    }
};
