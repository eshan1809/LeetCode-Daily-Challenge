class Solution {
    private int helper(int[] piles, int s, int e, int p, Integer[][][] dp){
        if(s > e)
            return 0;
        if(dp[s][e][p] != null)
            return dp[s][e][p];
        int x = helper(piles, s + 1, e, 1 - p, dp);
        int y = helper(piles, s, e - 1, 1 - p, dp);
        if(p == 0){
            dp[s][e][p] = Math.max(piles[s] + x, piles[e] + y);
            return dp[s][e][p];
        }
            
        else{
            dp[s][e][p] = Math.min(x - piles[s], y - piles[e]);
            return dp[s][e][p];
        }
    }
    public boolean stoneGame(int[] piles) {
        return helper(piles, 0, piles.length - 1, 0, new Integer[piles.length][piles.length][2]) > 0;
    }
}
