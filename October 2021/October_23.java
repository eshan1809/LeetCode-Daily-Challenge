class Solution {
    public int findMin(int[] nums) {
        int start = 0, end = nums.length - 1;
        while(start + 1 < end){
            if(nums[start] < nums[end])
                return nums[start];
            if(nums[start] == nums[end]){
                start++;
                continue;
            }
            int mid = (start + end) / 2;
            if(nums[start] > nums[mid])
                end = mid;
            else
                start = mid;
        }
        return Math.min(nums[start], nums[end]);
    }
}
