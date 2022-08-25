class Solution {
    public boolean isPowerOfThree(int n) {
        if(n <= 0)
            return false;
        double x = Math.log(n) / Math.log(3);
        if(Math.ceil(x) - x < x - Math.floor(x))
            x = Math.ceil(x);
        else
            x = Math.floor(x);
        return Math.pow(3, x) == n;
    }
}
