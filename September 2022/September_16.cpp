class Solution {
public:
    int helper(int i, vector<int> &multipliers, int lo, vector<int> &nums, vector<vector<int> > &dp){
        int hi = lo + nums.size() - i - 1;
        if(lo > hi || i == multipliers.size()){
            return 0;
        }
        if(dp[lo][i] != INT_MIN)
            return dp[lo][i];
        int f1 = nums[lo] * multipliers[i] + helper(i + 1, multipliers, lo + 1, nums, dp);
        int f2 = nums[hi] * multipliers[i] + helper(i + 1, multipliers, lo, nums, dp);
        dp[lo][i] = max(f1, f2);
        return dp[lo][i];
    }
    
    int maximumScore(vector<int>& nums, vector<int>& multipliers) {
        vector<vector<int> > dp(multipliers.size(), vector<int>(multipliers.size(), INT_MIN));
        return helper(0, multipliers, 0, nums, dp);
    }
};
