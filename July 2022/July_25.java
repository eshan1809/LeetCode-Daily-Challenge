class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = upper_bound(nums, target), last = lower_bound(nums, target);
        if(last == -1 || nums[last] != target)
            return new int[]{-1, -1};
        return new int[]{first, last};
    }
    
    private int lower_bound(int[] arr, int val) {
        int ans = -1, lo = 0, hi = arr.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (arr[mid] <= val) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return ans;
    }
    
    private int upper_bound(int[] arr, int val) {
        int ans = arr.length, lo = 0, hi = ans - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (arr[mid] >= val) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }
}
