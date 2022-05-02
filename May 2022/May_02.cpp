class Solution {
public:
    vector<int> sortArrayByParity(vector<int>& nums) {
        int n = nums.size(), i = 0, j = n - 1;
        vector<int> ans(n);
        for(int k = 0; k < n; k++){
            if((nums[k] & 1) == 0)
                ans[i++] = nums[k];
            else
                ans[j--] = nums[k];
        }
        return ans;
    }
};
