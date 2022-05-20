class Solution {
public:
    int uniquePathsWithObstacles(vector<vector<int>>& obstacleGrid) {
        int n = obstacleGrid.size(), m = obstacleGrid[0].size();
        if(obstacleGrid[n - 1][m - 1])
            return 0;
        unsigned int ways[n + 1][m + 1];
        memset(ways, 0, sizeof(ways));
        ways[n - 1][m - 1] = 1;
        obstacleGrid[n - 1][m - 1] = 1;
        for(int i = n - 1; i >= 0; i--)
            for(int j = m - 1; j >= 0; j--)
                if(!obstacleGrid[i][j])
                    ways[i][j] = ways[i][j + 1] + ways[i + 1][j];
        return ways[0][0];
    }
};
