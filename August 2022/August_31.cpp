class Solution {
public:
    int dirs[4][2] = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    int numRows, numCols;
    vector<vector<int>> landHeights;
    
    void dfs(int row, int col, vector<vector<bool>> &reachable) {
        reachable[row][col] = true;
        for (auto &dir : dirs) {
            int newRow = row + dir[0], newCol = col + dir[1];
            if (newRow < 0 || newRow >= numRows || newCol < 0 || newCol >= numCols)
                continue;
            if (reachable[newRow][newCol])
                continue;
            if (landHeights[newRow][newCol] < landHeights[row][col])
                continue;
            dfs(newRow, newCol, reachable);
        }
    }
    
    vector<vector<int>> pacificAtlantic(vector<vector<int>>& heights) {
        if (heights.size() == 0 || heights[0].size() == 0){
            vector<vector<int>> v;
            return v;
        }
        numRows = heights.size();
        numCols = heights[0].size();
        landHeights = heights;
        vector<vector<bool>> pacificReachable(numRows, vector<bool>(numCols, false));
        vector<vector<bool>> atlanticReachable(numRows, vector<bool>(numCols, false));
        for (int i = 0; i < numRows; i++) {
            dfs(i, 0, pacificReachable);
            dfs(i, numCols - 1, atlanticReachable);
        }
        for (int i = 0; i < numCols; i++) {
            dfs(0, i, pacificReachable);
            dfs(numRows - 1, i, atlanticReachable);
        }
        vector<vector<int>> commonCells;
        for (int i = 0; i < numRows; i++)
            for (int j = 0; j < numCols; j++) 
                if(pacificReachable[i][j] && atlanticReachable[i][j]) {
                    vector<int> v;
                    v.push_back(i);
                    v.push_back(j);
                    commonCells.push_back(v);
                }
        return commonCells;
    }
};
