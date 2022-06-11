class Solution {
    public int minOperations(int[] nums, int x) {
        n = nums.length;
        sum = new int[n + 1];
        for(int i = 1; i <= n; i++)
            sum[i] = sum[i - 1] + nums[i - 1];
        
        ans = -1;
        r = 0;
        this.x = x;
        
        binS(n);
        for(int i = n - 1; i > 0; i--){
            r += nums[i];
            binS(i);
        }
        return ans;
    }
    
    int[] sum;
    int ans, r, x, n;
    
    private void binS(int i){
        int lo = 0, hi = i, v = -1;
        while(lo <= hi){
            int mid = (lo + hi) >> 1;
            if(sum[mid] + r > x)
                hi = mid - 1;
            else if(sum[mid] + r < x)
                lo = mid + 1;
            else{
                v = mid;
                hi = mid - 1;
            }
        }
        if(v != -1){
            if(ans == -1)
                ans = n - i + v;
            else
                ans = Math.min(ans, n - i + v);
        }
    }
}
