class Solution {
public:
    bool isSafe(int i, int j, vector<string> &board, int n){
        int r = i - 1, c = j;
        while(r >= 0){
            if(board[r][c] == 'Q')
                return false;
            r--;
        }
        
        r = i - 1, c = j - 1;
        while(r >= 0 && c >= 0){
            if(board[r][c] == 'Q')
                return false;
            r--, c--;
        }
        
        r = i - 1, c = j + 1;
        while(r >= 0 && c < n){
            if(board[r][c] == 'Q')
                return false;
            r--, c++;
        }
        
        return true;
    }
    
    void helper(int i, int n, vector<string> &board, vector<vector<string>> &ans){
        if(i == n){
            vector<string> tmp(n);
            for(int j = 0; j < n; j++)
                tmp[j] = board[j];
            ans.push_back(tmp);
            return;
        }
        
        for(int j = 0; j < n; j++)
            if(isSafe(i, j, board, n)){
                board[i][j] = 'Q';
                helper(i + 1, n, board, ans);
                board[i][j] = '.';
            }
    }
    
    vector<vector<string>> solveNQueens(int n) {
        string line;
        for(int i = 0; i < n; i++)
            line += '.';
        
        vector<string> board(n, line);
        
        vector<vector<string>> ans;
        helper(0, n, board, ans);
        return ans;
    }
};
