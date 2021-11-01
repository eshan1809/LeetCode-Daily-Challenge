class Solution {
    public void helper(char[][] board, int i, int j){
        if(i < 0 || j < 0 || i == board.length || j == board[0].length || board[i][j] != 'O')
            return;
        board[i][j] = 'Z';
        helper(board, i + 1, j);
        helper(board, i - 1, j);
        helper(board, i, j + 1);
        helper(board, i, j - 1);
    }
  
    public void solve(char[][] board) {
        int n = board.length, m = board[0].length;
        for(int i = 0; i < n; i++){
            if(board[i][0] == 'O')
                helper(board, i, 0);
            if(board[i][m - 1] == 'O')
                helper(board, i, m - 1);
        }
        for(int i = 1; i < m - 1; i++){
            if(board[0][i] == 'O')
                helper(board, 0, i);
            if(board[n - 1][i] == 'O')
                helper(board, n - 1, i);
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == 'Z')
                    board[i][j] = 'O';
                else if(board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
    }
}
