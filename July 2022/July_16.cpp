class Solution {
public:
    int mod = (int)(1e9 + 7);
    
    int helper(int m, int n, int maxMove, int x, int y, vector<vector<vector<int>>>& dp){
        if(x == -1 || y == -1 || x == m || y == n)
            return 1;
        if(dp[x][y][maxMove] != -1)
            return dp[x][y][maxMove];
        if(maxMove > 0){
            long ans = helper(m, n, maxMove - 1, x - 1, y, dp);
            ans += helper(m, n, maxMove - 1, x + 1, y, dp);
            ans += helper(m, n, maxMove - 1, x, y - 1, dp);
            ans += helper(m, n, maxMove - 1, x, y + 1, dp);
            return dp[x][y][maxMove] = (int)(ans % mod);
        }
        return 0;
    }
    
    int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        vector<vector<vector<int>>> dp(m, vector<vector<int>>(n, vector<int>(maxMove + 1, -1)));
        return helper(m, n, maxMove, startRow, startColumn, dp);
    }
};
