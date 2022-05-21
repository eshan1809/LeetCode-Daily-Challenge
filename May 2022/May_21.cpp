class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        sort(coins.begin(), coins.end());
        int n = coins.size();
        vector<vector<int> > dp(n, vector<int>(amount + 1, - 1));
        int ans = helper(coins, amount, n - 1, dp);
        return ans >= 100 ? -1 : ans;
    }
    
    int helper(vector<int>& coins, int amount, int i, vector<vector<int> >& dp){
        if(amount == 0)
            return 0;
        if(amount < 0 || i < 0)
            return 100;
        if(dp[i][amount] != -1)
            return dp[i][amount];
        return dp[i][amount] = min(1 + helper(coins, amount - coins[i], i, dp), helper(coins, amount, i - 1, dp));
    }
};
