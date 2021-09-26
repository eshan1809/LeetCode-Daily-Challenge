class Solution {
    public int movesToChessboard(int[][] board) {
        int n = board.length;
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                if((board[0][0] ^ board[0][j] ^ board[i][0] ^ board[i][j]) == 1)
                    return -1;
        int rSum = 0, cSum = 0, rSwap = 0, cSwap = 0;
        for(int i = 0; i < n; i++){
            rSum += board[0][i];
            cSum += board[i][0];
            if(i % 2 == board[i][0])
                rSwap++;
            if(i % 2 == board[0][i])
                cSwap++;
        }
        if((rSum != n / 2 && rSum != (n + 1) / 2) || (cSum != n / 2 && cSum != (n + 1) / 2))
            return -1;
        if(n % 2 == 1){
            if(rSwap % 2 == 1)
                rSwap = n - rSwap;
            if(cSwap % 2 == 1)
                cSwap = n - cSwap;
        } else{
            rSwap = Math.min(rSwap, n - rSwap);
            cSwap = Math.min(cSwap, n - cSwap);
        }
        return (rSwap + cSwap) / 2;
    }
}
