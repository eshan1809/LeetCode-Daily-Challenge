class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n];
        for(int i = n - 1; i >= 0; i--){
            if(s.charAt(i) == '0')
                dp[i] = 0;
            else{
                dp[i] = i + 1 < n ? dp[i + 1] : 1;
                if(i + 1 < n){
                    int num = Integer.parseInt(s.substring(i, i + 2));
                    if(num < 27)
                        dp[i] += i + 2 < n ? dp[i + 2] : 1;
                }
            }
        }
        return dp[0];
    }
}
