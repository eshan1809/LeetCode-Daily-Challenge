class Solution {
public:
    bool checkPossibility(vector<int>& nums) {
        int n = nums.size();
        if(n <= 2)
            return true;
        if(nums[0] > nums[1])
            nums[0] = nums[1];
        else{
            for(int i = 1; i < n - 1; i++)
                if(nums[i] > nums[i + 1]){
                    if(nums[i + 1] < nums[i - 1])
                        nums[i + 1] = nums[i];
                    else
                        nums[i] = nums[i + 1];
                    break;
                }
        }
        for(int i = 1; i < n; i++)
            if(nums[i] < nums[i - 1])
                return false;
        return true;
    }
};
