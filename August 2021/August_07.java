class Solution {
    public int minCut(String s) {
        int n = s.length();
        return helper(s, 0, n - 1, new Integer[n][n]);
    }

    public int helper(String str, int i, int j, Integer[][] dp){
        if(i >= j)
            return 0;
        
        if(dp[i][j] != null)
            return dp[i][j];

        if(isPalindrome(str, i, j))
            return dp[i][j] = 0;

        int ans = Integer.MAX_VALUE;
        
        for(int k = i; k <= j; k++)
            if(isPalindrome(str, i, k))
                ans = Math.min(ans, 1 + helper(str, k + 1, j, dp));
        
        return dp[i][j] = ans;
    }
    
    public boolean isPalindrome(String str, int s, int e){
        while(s < e)
            if(str.charAt(s++) != str.charAt(e--))
                return false;
        return true;
    }
}
