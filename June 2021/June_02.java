class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n1 = s1.length(), n2 = s2.length(), n3 = s3.length();
        if(n1 + n2 != n3) return false;
        boolean[][] dp = new boolean[n1 + 1][n2 + 1];
        dp[n1][n2] = true;
        for(int i = 1; i <= n1; i++)
            if(s1.charAt(n1 - i) == s3.charAt(n3 - i) && dp[n1 - i + 1][n2]) dp[n1 - i][n2] = true;
        for(int i = 1; i <= n2; i++)
            if(s2.charAt(n2 - i) == s3.charAt(n3 - i) && dp[n1][n2 - i + 1]) dp[n1][n2 - i] = true;
        for(int i = n1 - 1; i >= 0; i--){
            for(int j = n2 - 1; j >= 0; j--){
                if(s1.charAt(i) == s3.charAt(i + j) && dp[i + 1][j]) dp[i][j] = true;
                else if(s2.charAt(j) == s3.charAt(i + j) && dp[i][j + 1]) dp[i][j] = true;
            }
        }
        return dp[0][0];
    }
}
