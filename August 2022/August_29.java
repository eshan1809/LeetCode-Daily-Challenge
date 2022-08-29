class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
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
    private void dfs(char[][] grid, boolean[][] vis, int i, int j){
        if(i < 0 || j < 0 || i == grid.length || j == grid[0].length || vis[i][j] || grid[i][j] == '0')
            return;
        vis[i][j] = true;
        dfs(grid, vis, i + 1, j);
        dfs(grid, vis, i, j + 1);
        dfs(grid, vis, i - 1, j);
        dfs(grid, vis, i, j - 1);
    }
}
