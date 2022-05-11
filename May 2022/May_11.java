class Solution {
    public int countVowelStrings(int n) {
        return helper(0, n, new Integer[5][n + 1]);
    }
    
    private int helper(int i, int n, Integer[][] dp){
        if(n == 0)
            return 1;
        if(i == 5)
            return 0;
        if(dp[i][n] == null)
            dp[i][n] = helper(i, n - 1, dp) + helper(i + 1, n, dp);
        return dp[i][n];
    }
}
