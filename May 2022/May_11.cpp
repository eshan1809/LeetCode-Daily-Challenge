class Solution {
public:
    int helper(int i, int n, vector<vector<int> > &dp){
        if(n == 0)
            return 1;
        if(i == 5)
            return 0;
        if(dp[i][n] == -1)
            dp[i][n] = helper(i, n - 1, dp) + helper(i + 1, n, dp);
        return dp[i][n];
    }
    
    int countVowelStrings(int n) {
        vector<vector<int> > dp(5, vector<int> (n + 1, -1));
        return helper(0, n, dp);
    }
};
