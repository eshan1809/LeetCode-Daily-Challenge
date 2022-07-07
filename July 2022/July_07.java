class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        l1 = s1.length();
        l2 = s2.length();
        l3 = s3.length();
        return helper(s1, s2, s3, 0, 0, new Boolean[l1 + 1][l2 + 1]);
    }
    
    int l1, l2, l3;
    
    private boolean helper(String s1, String s2, String s3, int i1, int i2, Boolean[][] dp){
        int i3 = i1 + i2;
        if(i3 == l3)
            return i1 == l1 && i2 == l2;
        if(dp[i1][i2] != null)
            return dp[i1][i2];
        boolean ans = false;
        if(i1 < l1 && s1.charAt(i1) == s3.charAt(i3))
            ans = helper(s1, s2, s3, i1 + 1, i2, dp);
        if(ans)
            return dp[i1][i2] = ans;
        if(i2 < l2 && s2.charAt(i2) == s3.charAt(i3))
            ans = helper(s1, s2, s3, i1, i2 + 1, dp);
        return dp[i1][i2] = ans;
    }
}
