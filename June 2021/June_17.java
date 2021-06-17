class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int start = -1, end = -1, ans = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > right){
                start = i;
                end = i;
            } else if(nums[i] >= left && nums[i] <= right)
                end = i;
            ans += end - start;
        }
        return ans;
    }
}
