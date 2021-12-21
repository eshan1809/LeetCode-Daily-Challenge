class Solution {
    public boolean isPowerOfTwo(int n) {
        int res = 0;
        while(n > 0){
            long rsb = n & -n;
            n -= rsb;
            res++;
        }
        return res == 1;
    }
}
