class Solution {
    public int countSubstrings(String s) {
        int n = s.length(), count = 0;
        boolean[][] dp = new boolean[n][n];
        for(int k = 0; k < n; k++){
            for(int i = 0, j = k; j < n; i++, j++){
                if(k == 0)
                    dp[i][j] = true;
                else if(k == 1)
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                else
                    dp[i][j] = (s.charAt(i) == s.charAt(j)) && dp[i + 1][j - 1];
                if(dp[i][j])
                    count++;
            }
        }
        return count;
    }
}
