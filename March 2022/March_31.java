class Solution {
    public int splitArray(int[] nums, int m) {
        int lo = 0, hi = 0, n = nums.length;
        for(int i = 0; i < n; i++){
            lo = Math.max(lo, nums[i]);
            hi += nums[i];
        }
        int ans = hi;
        while(lo <= hi){
            int mid = (lo + hi) / 2;
            int count = 1, sum = 0;
            for(int i = 0; i < n; i++){
                if(sum + nums[i] > mid){
                    sum = 0;
                    count++;
                }
                sum += nums[i];
            }
            if(count <= m){
                ans = mid;
                hi = mid - 1;
            } else{
                lo = mid + 1;
            }
        }
        return ans;
    }
}
