class Solution {
    public boolean isPowerOfFour(int n) {
        if(n == 0)
            return false;
        return Math.pow(4, (int)(Math.log(n) / Math.log(4))) == n;
    }
}
