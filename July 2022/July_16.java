class Solution {
    
    int mod = (int)(1e9 + 7);
    Integer[][][] dp;
    
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        if(dp == null)
            dp = new Integer[m][n][maxMove + 1];
        if(startRow == -1 || startColumn == -1 || startRow == m || startColumn == n)
            return 1;
        if(dp[startRow][startColumn][maxMove] != null)
            return dp[startRow][startColumn][maxMove];
        if(maxMove > 0){
            long ans = findPaths(m, n, maxMove - 1, startRow - 1, startColumn);
            ans += findPaths(m, n, maxMove - 1, startRow + 1, startColumn);
            ans += findPaths(m, n, maxMove - 1, startRow, startColumn - 1);
            ans += findPaths(m, n, maxMove - 1, startRow, startColumn + 1);
            return dp[startRow][startColumn][maxMove] = (int)(ans % mod);
        }
        return 0;
    }
}
