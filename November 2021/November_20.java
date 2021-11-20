class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length, lo = 0, hi = n - 1;
        while(lo < hi){
            int mid = (hi + lo) / 2;
            if(mid % 2 == 0){
                if(mid > 0 && nums[mid - 1] == nums[mid])
                    hi = mid - 1;
                else if(mid < n && nums[mid + 1] == nums[mid])
                    lo = mid + 1;
                else
                    return nums[mid];
            } else{
                if(nums[mid - 1] == nums[mid])
                    lo = mid + 1;
                else if(nums[mid + 1] == nums[mid])
                    hi = mid - 1;
                else
                    return nums[mid];
            }
        }
        return nums[lo];
    }
}
