class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        vis = new boolean[n][m];
        int ans = 0;
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                if(!vis[i][j])
                    ans = Math.max(ans, dfs(i, j, grid));
        return ans;
    }
    
    int n, m;
    boolean[][] vis;
    
    private int dfs(int i, int j, int[][] grid){
        if(i < 0 || j < 0 || i == n || j == m || vis[i][j] || grid[i][j] == 0)
            return 0;
        vis[i][j] = true;
        return dfs(i - 1, j, grid) + dfs(i, j - 1, grid) + dfs(i + 1, j, grid) + dfs(i, j + 1, grid) + 1;
    }
}
