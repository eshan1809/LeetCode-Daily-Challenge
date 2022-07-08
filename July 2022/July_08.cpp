class Solution {
public:
    int Max = (int) 1e9;
    int helper(vector<int>& houses, vector<vector<int>>& cost, int m, int n, int target, int prev, int idx, vector<vector<vector<int>>> &dp){
        if(target < 0)
            return Max;
        if(idx == m){
            if(target == 0)
                return 0;
            return Max;
        }
        if(dp[target][prev][idx] != -1)
            return dp[target][prev][idx];
        if(houses[idx] != 0){
            if(houses[idx] == prev)
                return dp[target][prev][idx] = helper(houses, cost, m, n, target, prev, idx + 1, dp);
            return dp[target][prev][idx] = helper(houses, cost, m, n, target - 1, houses[idx], idx + 1, dp);
        }
        int ans = Max;
        for(int i = 1; i <= n; i++){
            if(i == prev)
                ans = min(ans, cost[idx][i - 1] + helper(houses, cost, m, n, target, i, idx + 1, dp));
            else
                ans = min(ans, cost[idx][i - 1] + helper(houses, cost, m, n, target - 1, i, idx + 1, dp));
        }
        return dp[target][prev][idx] = ans;
    }
    
    int minCost(vector<int>& houses, vector<vector<int>>& cost, int m, int n, int target) {
        vector<vector<vector<int>>> dp(target + 1, vector<vector<int>>(n + 1, vector<int>(m + 1, -1)));
        int ans = helper(houses, cost, m, n, target, 0, 0, dp);
        return ans == Max ? -1 : ans; 
    }
};
