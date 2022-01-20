class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int lo = 1, hi = 0, n = piles.length;
        for(int i = 0; i < n; i++)
            hi = Math.max(hi, piles[i]);
        int ans = hi;
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2, time = 0;
            for(int i = 0; i < n; i++)
                time += (int)Math.ceil(1.0 * piles[i] / mid);
            if(time <= h){
                ans = mid;
                hi = mid - 1;
            } else
                lo = mid + 1;
        }
        return ans;
    }
}
