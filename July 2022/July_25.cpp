class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        int first = lower_bound(nums.begin(), nums.end(), target) - nums.begin();
        int last = upper_bound(nums.begin(), nums.end(), target) - nums.begin() - 1;
        vector<int> ans(2, -1);
        if(first == nums.end() - nums.begin() || nums[first] != target)
            return ans;
        ans[0] = first;
        ans[1] = last;
        return ans;
    }
};
