class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == 0)
            return 0;
        else if(divisor == 1)
            return dividend;
        else if(divisor == -1){
            if(dividend == Integer.MIN_VALUE)
                dividend++;
            return -dividend;
        }
        
        int sign = 1;
        if((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0))
            sign = -1;
        
        long dd = Math.abs((long)dividend), d = Math.abs((long)divisor);
        int ans = 0;
        while(dd >= d){
            long t = d, x = 1;
            while(t <= dd){
                t <<= 1;
                x <<= 1;
            }
            x >>= 1;
            ans += (int)x;
            dd -= t >> 1;
        }
        
        return sign * ans;
    }
}
