class Solution {
    public void solveSudoku(char[][] board) {
        solve(0, 0, board);
    }
    
    public boolean solve(int i, int j, char[][] board){
        if(j == 9){
            i++;
            j = 0;
        }
        
        if(i == 9)
            return true;
        
        if(board[i][j] == '.'){
            for(char val = '1'; val <= '9'; val++){
                if(canPlace(i, j, board, val)){
                    board[i][j] = val;
                    if(solve(i, j + 1, board))
                        return true;
                    board[i][j] = '.';
                }
            }
        } else
            return solve(i, j+1, board);
        return false;
    }
    
    public boolean canPlace(int i, int j, char[][] board, char num){
        for(int r = 0; r < 9; r++)
            if(board[r][j] == num)
                return false;
        
        for(int c = 0; c < 9; c++)
            if(board[i][c] == num)
                return false;
        
        int r = 3 * (i / 3), c = 3 * (j / 3);
        for(int x = r; x < r + 3; x++)
            for(int y = c; y < c + 3; y++)
                if(board[x][y] == num)
                    return false;
        
        return true;
    }
}
