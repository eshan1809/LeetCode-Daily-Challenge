class Solution {
public:
    int maxSumSubmatrix(vector<vector<int>>& matrix, int k) {
        int ans = INT_MIN, n = matrix.size(), m = matrix[0].size();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                int grid[n - i][m - j];
                grid[0][0] = matrix[i][j];
                if(grid[0][0] == k)
                    return k;
                if(grid[0][0] < k)
                    ans = max(ans, grid[0][0]);
                for(int p = 0; p < n - i; p++){
                    for(int q = 0; q < m - j; q++){
                        if(p == 0 && q == 0)
                            continue;
                        else if(p == 0)
                            grid[p][q] = grid[p][q - 1] + matrix[i][j + q];
                        else if(q == 0)
                            grid[p][q] = grid[p - 1][q] + matrix[i + p][j];
                        else
                            grid[p][q] = matrix[i + p][j + q] + grid[p - 1][q] + grid[p][q - 1] - grid[p - 1][q - 1];
                        if(grid[p][q] == k)
                            return k;
                        if(grid[p][q] < k)
                            ans = max(ans, grid[p][q]);
                    }
                }
            }
        }
        return ans;
    }
};
