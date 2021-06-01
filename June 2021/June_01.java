class Solution {
    public int getArea(int[][] grid, int r, int c){
        if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0)
            return 0;
        grid[r][c] = 0;
        return getArea(grid, r - 1, c) + getArea(grid, r, c + 1) + getArea(grid, r + 1, c) + getArea(grid, r, c - 1) + 1;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1)
                    maxArea = Math.max(getArea(grid, i, j), maxArea);
            }
        }
        return maxArea;
    }
}
