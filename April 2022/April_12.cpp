class Solution {
public:
    void gameOfLife(vector<vector<int>>& board) {
        int n = board.size(), m = board[0].size();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                int count = 0;
                if(i - 1 >= 0 && j - 1 >= 0 && (board[i - 1][j - 1] == 1 || board[i - 1][j - 1] == -1))
                    count++;
                if(i - 1 >= 0 && (board[i - 1][j] == 1 || board[i - 1][j] == -1))
                    count++;
                if(i - 1 >= 0 && j + 1 < m && (board[i - 1][j + 1] == 1 || board[i - 1][j + 1] == -1))
                    count++;
                if(j - 1 >= 0 && (board[i][j - 1] == 1 || board[i][j - 1] == -1))
                    count++;
                if(j + 1 < m && (board[i][j + 1] == 1 || board[i][j + 1] == -1))
                    count++;
                if(i + 1 < n && j - 1 >= 0 && (board[i + 1][j - 1] == 1 || board[i + 1][j - 1] == -1))
                    count++;
                if(i + 1 < n && (board[i + 1][j] == 1 || board[i + 1][j] == -1))
                    count++;
                if(i + 1 < n && j + 1 < m && (board[i + 1][j + 1] == 1 || board[i + 1][j + 1] == -1))
                    count++;
                
                if(count < 2 && board[i][j] == 1)
                    board[i][j] = -1;
                if(count == 3 && board[i][j] == 0)
                    board[i][j] = 2;
                if(count > 3 && board[i][j] == 1)
                    board[i][j] = -1;
            }
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == -1)
                    board[i][j] = 0;
                if(board[i][j] == 2)
                    board[i][j] = 1;
            }
        }
    }
};
