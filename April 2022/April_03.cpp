class Solution {
public:
    void nextPermutation(vector<int>& nums) {
        int n = nums.size(), lo = 0;
        for(int i = n - 2; i >= 0; i--){
            if(nums[i] < nums[i + 1]){
                for(int j = n - 1; j > i; j--){
                    if(nums[j] > nums[i]){
                        swap(nums[i], nums[j]);
                        lo = i + 1;
                        break;
                    }
                }
            }
            if(lo == i + 1)
                break;
        }
        while(lo < n)
            swap(nums[lo++], nums[--n]);
    }
};
