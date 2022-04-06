class Solution {
public:
    int dp[3000][3][300];
    int mod = (int)(1e9+7);
    
    int helper(vector<int>& nums, int idx, int pick, int sum, int target){
        if(pick == 3){
            if(sum == target)
                return 1;
            return 0;
        }
        if(sum > target || idx == nums.size())
            return 0;
        if(dp[idx][pick][sum] != -1)
            return dp[idx][pick][sum];
        
        int ans = helper(nums, idx + 1, pick + 1, sum + nums[idx], target) + helper(nums, idx + 1, pick, sum, target);
        
        return dp[idx][pick][sum] = ans % mod;
    }
    
    int threeSumMulti(vector<int>& arr, int target) {
        memset(dp, -1, sizeof(dp));
        return helper(arr, 0, 0, 0, target);
    }
};
