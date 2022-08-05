class Solution {
public:
    int helper(vector<int> &nums, int id, int target, vector<vector<int>> &dp){
        if(target < 0)
            return 0;
        if(id == nums.size()){
            if(target == 0)
                return 1;
            return 0;
        }
        if(dp[id][target] != -1)
            return dp[id][target];
        return dp[id][target] = helper(nums, 0, target - nums[id], dp) + helper(nums, id + 1, target, dp);
    }
    
    int combinationSum4(vector<int>& nums, int target) {
        int n = nums.size();
        vector<vector<int>> dp(n, vector<int>(target +  1, -1));
        return helper(nums, 0, target, dp);
    }
};
