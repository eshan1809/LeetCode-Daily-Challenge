class Solution {
public:
    int n, m;
    
    int dfs(int i, int j, vector<vector<int>>& grid, vector<vector<bool>>& vis){
        if(i < 0 || j < 0 || i == n || j == m || vis[i][j] || grid[i][j] == 0)
            return 0;
        vis[i][j] = true;
        return dfs(i - 1, j, grid, vis) + dfs(i, j - 1, grid, vis) + dfs(i + 1, j, grid, vis) + dfs(i, j + 1, grid, vis) + 1;
    }
    
    int maxAreaOfIsland(vector<vector<int>>& grid) {
        n = grid.size();
        m = grid[0].size();
        vector<vector<bool>> vis(n, vector<bool>(m, false));
        int ans = 0;
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                if(!vis[i][j])
                    ans = max(ans, dfs(i, j, grid, vis));
        return ans;
    }
};
