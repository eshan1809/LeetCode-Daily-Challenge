class Solution {
public:
    int ans;
    bool isSafe(int i, int j, int n, vector<vector<bool> > &board){
        int r = i - 1, c = j;
        while(r >= 0)
            if(board[r--][c])
                return false;
        
        r = i - 1, c = j - 1;
        while(r >= 0 && c >= 0)
            if(board[r--][c--])
                return false;
        
        r = i - 1, c = j + 1;
        while(r >= 0 && c < n)
            if(board[r--][c++])
                return false;
        return true;
    }
    
    void helper(int i, int n, vector<vector<bool> > &board){
        if(i == n){
            ans++;
            return;
        }
        
        for(int j = 0; j < n; j++){
            if(isSafe(i, j, n, board)){
                board[i][j] = true;
                helper(i + 1, n, board);
                board[i][j] = false;
            }
        }
    }
    
    int totalNQueens(int n) {
        vector<vector<bool> > board(n, vector<bool>(n));
        ans = 0;
        helper(0, n, board);
        return ans;
    }
};
