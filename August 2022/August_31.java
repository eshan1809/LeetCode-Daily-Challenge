class Solution {
    final int[][] dirs = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    int numRows, numCols;
    int[][] landHeights;
    
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return new ArrayList<>();
        numRows = matrix.length;
        numCols = matrix[0].length;
        landHeights = matrix;
        boolean[][] pacificReachable = new boolean[numRows][numCols], atlanticReachable = new boolean[numRows][numCols];
        for (int i = 0; i < numRows; i++) {
            dfs(i, 0, pacificReachable);
            dfs(i, numCols - 1, atlanticReachable);
        }
        for (int i = 0; i < numCols; i++) {
            dfs(0, i, pacificReachable);
            dfs(numRows - 1, i, atlanticReachable);
        }
        List<List<Integer>> commonCells = new ArrayList<>();
        for (int i = 0; i < numRows; i++)
            for (int j = 0; j < numCols; j++) 
                if(pacificReachable[i][j] && atlanticReachable[i][j]) 
                    commonCells.add(List.of(i, j));
        return commonCells;
    }
    
    private void dfs(int row, int col, boolean[][] reachable) {
        reachable[row][col] = true;
        for (int[] dir : dirs) {
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
}
