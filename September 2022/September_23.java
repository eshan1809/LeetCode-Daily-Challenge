class Solution {
    public int concatenatedBinary(int n) {
        int mod = (int)(1e9 + 7);
        long ans = 0L;
        for(int i = 1; i <= n; i++){
            ans <<= ((int)(Math.log(i) / Math.log(2)) + 1);
            ans %= mod;
            ans += i;
            ans %= mod;
        }
        return (int) ans;
    }
}
