class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        if(obstacleGrid[n - 1][m - 1] == 1)
            return 0;
        int[][] ways = new int[n + 1][m + 1];
        ways[n - 1][m - 1] = 1;
        obstacleGrid[n - 1][m - 1] = 1;
        for(int i = n - 1; i >= 0; i--)
            for(int j = m - 1; j >= 0; j--)
                if(obstacleGrid[i][j] == 0)
                    ways[i][j] = ways[i + 1][j] + ways[i][j + 1];
        return ways[0][0];
    }
}
