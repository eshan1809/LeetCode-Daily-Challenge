class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; i++)
            for(int j = 0; j < 9; j++)
                if(board[i][j] != '.' && !isValid(board, i, j))
                    return false;
        
        return true;
    }
    
    private boolean isValid(char[][] board, int r, int c){
        int i = r, j = c;
        while(--i >= 0)
            if(board[i][j] == board[r][c])
                return false;
        
        i = r;
        while(++i < 9)
            if(board[i][j] == board[r][c])
                return false;
        
        i = r;
        while(--j >= 0)
            if(board[i][j] == board[r][c])
                return false;
        
        j = c;
        while(++j < 9)
            if(board[i][j] == board[r][c])
                return false;
        
        int x = r / 3, y = c / 3;
        for(int p = 3 * x; p < 3 * x + 3; p++){
            for(int q = 3 * y; q < 3 * y + 3; q++){
                if(p == r && q == c)
                    continue;
                if(board[p][q] == board[r][c])
                    return false;
            }
        }
        
        return true;
    }
}
