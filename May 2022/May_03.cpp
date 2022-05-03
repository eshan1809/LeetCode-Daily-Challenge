class Solution {
public:
    int findUnsortedSubarray(vector<int>& nums) {
        int n = nums.size(), i = 0, j = n - 1;
        vector<int> sorted(n);
        for(int i = 0; i < n; i++)
            sorted[i] = nums[i];
        sort(sorted.begin(), sorted.end());
        while(i <= j && sorted[i] == nums[i])
            i++;
        while(i <= j && sorted[j] == nums[j])
            j--;
        return j - i + 1;
    }
};
