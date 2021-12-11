class Solution {
    public int nthMagicalNumber(int n, int a, int b) {
        long lo = 1, hi = Long.MAX_VALUE;
        int lcm = lcm(a, b), mod = 1000000007;
        while(lo < hi){
            long mid = (lo + hi) / 2;
            long val = (mid / a) + (mid / b) - (mid / lcm);
            if(val >= n)
                hi = mid;
            else
                lo = mid + 1;
        }
        return (int)(hi % mod);
    }
    
    private int lcm(int a, int b){
        return a * b / gcd(a, b);
    }
    
    private int gcd(int a, int b){
        if(b == 0)
            return a;
        return gcd(b, a % b);
    }
}
