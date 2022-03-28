class Solution {
    public boolean search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while(lo <= hi){
            int mid = (lo + hi) / 2;
            if(nums[mid] == target || nums[hi] == target || nums[lo] == target)
                return true;
            if(nums[mid] > nums[lo]){
                if(target < nums[mid] && target > nums[lo])
                    hi = mid - 1;
                else
                    lo = mid + 1;
            } else if(nums[mid] < nums[lo]){
                if(target < nums[hi] && target > nums[mid])
                    lo = mid + 1;
                else
                    hi = mid - 1;
            } else
                hi--;
        }
        return false;
    }
}
