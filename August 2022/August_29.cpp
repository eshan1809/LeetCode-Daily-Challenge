class Solution {
public:
    int numIslands(vector<vector<char>>& grid) {
        int n = grid.size(), m = grid[0].size();
        vector<vector<bool>> vis(n, vector<bool>(m, false));
        int c = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!vis[i][j] && grid[i][j] == '1'){
                    dfs(grid, vis, i, j);
                    c++;
                }
            }
        }
        return c;
    }
    
    void dfs(vector<vector<char>>& grid, vector<vector<bool>> &vis, int i, int j){
        if(i < 0 || j < 0 || i == grid.size() || j == grid[0].size() || vis[i][j] || grid[i][j] == '0')
            return;
        vis[i][j] = true;
        dfs(grid, vis, i + 1, j);
        dfs(grid, vis, i, j + 1);
        dfs(grid, vis, i - 1, j);
        dfs(grid, vis, i, j - 1);
    }
};
