class Solution {
public:
    int maximumUniqueSubarray(vector<int>& nums) {
        unordered_set<int> hs;
        int sum = 0, mx = 0, n = nums.size(), j = 0;
        for(int i = 0; i < n; i++){
            while(hs.find(nums[i]) != hs.end()){
                sum -= nums[j];
                hs.erase(nums[j++]);
            }
            sum += nums[i];
            hs.insert(nums[i]);
            mx = max(mx, sum);
        }
        return mx;
    }
};
