class Solution {
    public boolean winnerSquareGame(int n) {
        boolean[] dp = new boolean[n + 1];
        dp[1] = true;
        for(int i = 2; i <= n; i++){
            for(int k = 1; k * k <= i; k++){
                if(!dp[i - k * k]){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
