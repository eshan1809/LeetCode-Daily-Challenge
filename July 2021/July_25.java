class Solution {
    public int findIntegers(int n) {
        int[] dp = new int[32];
        dp[0] = 1;
        dp[1] = 2;
        for(int i = 2; i < 32; i++)
            dp[i] = dp[i - 1] + dp[i - 2];
        int i = 30, count = 0, prev = 0;
        while (i >= 0){
            int bit = (n & (1 << i));
            if(bit > 0){
                count += dp[i];
                if(prev == 1) {
                    count--;
                    break;
                }
            }
            prev = bit > 0 ? 1 : 0;
            i--;
        }
        return count + 1;
    }
}
