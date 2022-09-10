class Solution {
public:
    int maxProfit(int k, vector<int>& prices) {
        int n = prices.size();
        if(n < 2 || k == 0)
            return 0;
        vector<vector<int> > dp(k + 1, vector<int>(n, 0));
        for(int i = 1; i <= k; i++){
            int mx = INT_MIN;
            for(int j = 1; j < n; j++){
                mx = max(mx, dp[i - 1][j - 1] - prices[j - 1]);
                dp[i][j] = max(mx + prices[j], dp[i][j - 1]);
            }
        }
        return dp[k][n - 1];
    }
};
