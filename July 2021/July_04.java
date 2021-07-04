class Solution {
    int mod = 1000000007;
    
    public int helper(char prev, int n, int[][] dp){
        if(n == 0) return 1;
        long ans = 0;
        if(prev == 'a'){
            if(dp[0][n] != 0) return dp[0][n];
            ans = (ans + helper('e', n - 1, dp)) % mod;
            dp[0][n] = (int)ans;
        } else if(prev == 'e'){
            if(dp[1][n] != 0) return dp[1][n];
            ans = (ans + helper('a', n - 1, dp)) % mod;
            ans = (ans + helper('i', n - 1, dp)) % mod;
            dp[1][n] = (int)ans;
        } else if(prev == 'i'){
            if(dp[2][n] != 0) return dp[2][n];
            ans = (ans + helper('a', n - 1, dp)) % mod;
            ans = (ans + helper('e', n - 1, dp)) % mod;
            ans = (ans + helper('o', n - 1, dp)) % mod;
            ans = (ans + helper('u', n - 1, dp)) % mod;
            dp[2][n] = (int)ans;
        } else if(prev == 'o'){
            if(dp[3][n] != 0) return dp[3][n];
            ans = (ans + helper('i', n - 1, dp)) % mod;
            ans = (ans + helper('u', n - 1, dp)) % mod;
            dp[3][n] = (int)ans;
        } else if(prev == 'u'){
            if(dp[4][n] != 0) return dp[4][n];
            ans = (ans + helper('a', n - 1, dp)) % mod;
            dp[4][n] = (int)ans;
        }
        return (int)ans;
    }
    
    public int countVowelPermutation(int n) {
        int[][] dp = new int[5][n];
        long ans = 0;
        ans = (ans + helper('a', n - 1, dp)) % mod;
        ans = (ans + helper('e', n - 1, dp)) % mod;
        ans = (ans + helper('i', n - 1, dp)) % mod;
        ans = (ans + helper('o', n - 1, dp)) % mod;
        ans = (ans + helper('u', n - 1, dp)) % mod;
        return (int)ans;
    }
}
