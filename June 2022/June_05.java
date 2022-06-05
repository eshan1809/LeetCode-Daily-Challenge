class Solution {
    public int totalNQueens(int n) {
        board = new boolean[n][n];
        ans = 0;        
        helper(0, n);
        return ans;
    }
    
    int ans;
    boolean[][] board;
    
    private void helper(int i, int n){
        if(i == n){
            ans++;
            return;
        }
        
        for(int j = 0; j < n; j++){
            if(isSafe(i, j, n)){
                board[i][j] = true;
                helper(i + 1, n);
                board[i][j] = false;
            }
        }
    }
    
    private boolean isSafe(int i, int j, int n){
        int r = i - 1, c = j;
        while(r >= 0)
            if(board[r--][c])
                return false;
        
        r = i - 1;
        c = j - 1;
        while(r >= 0 && c >= 0)
            if(board[r--][c--])
                return false;
        
        r = i - 1;
        c = j + 1;
        while(r >= 0 && c < n)
            if(board[r--][c++])
                return false;
        
        return true;
    }
}
