class Solution {
    public int uniquePathsIII(int[][] grid) {
        int count = 0, r = -1, c = -1;
        answers = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 0)
                    count++;
                else if(grid[i][j] == 1){
                    r = i;
                    c = j;
                }
            }
        }
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        visited[r][c] = true;
        helper(r - 1, c, 0, count, grid, visited);
        helper(r, c + 1, 0, count, grid, visited);
        helper(r + 1, c, 0, count, grid, visited);
        helper(r, c - 1, 0, count, grid, visited);
        return answers;
    }
    
    int answers;
    
    public void helper(int i, int j, int c, int t, int[][] grid, boolean[][] visited){
        if(i < 0 || i == grid.length || j < 0 || j == grid[0].length || visited[i][j] || grid[i][j] == -1)
            return;
        if(grid[i][j] == 2){
            if(c == t)
                answers++;
            return;
        }
        visited[i][j] = true;
        helper(i - 1, j, c + 1, t, grid, visited);
        helper(i, j + 1, c + 1, t, grid, visited);
        helper(i + 1, j, c + 1, t, grid, visited);
        helper(i, j - 1, c + 1, t, grid, visited);
        visited[i][j] = false;
    }
}
