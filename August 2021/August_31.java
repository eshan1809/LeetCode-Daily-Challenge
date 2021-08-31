class Solution {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length-1, res = nums[0];
        while(low <= high) {
            int mid = (low + high) / 2;
            res = Math.min(res, nums[mid]);
            if(nums[low] < nums[mid]) {
                res = Math.min(res, nums[low]);
                low = mid+1;
            } else if(nums[mid] < nums[high])
                high = mid-1;
            else
                low++;
        }
        return res;
    }
}
