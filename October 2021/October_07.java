class Solution {
    public boolean boardContains(char[][] board, String word, int r, int c, int idx, boolean[][] visited){
        if(idx == word.length()){
            return true;
        }
        if(r - 1 >= 0 && board[r - 1][c] == word.charAt(idx) && !visited[r - 1][c]){
            visited[r - 1][c] = true;
            if(boardContains(board, word, r - 1, c, idx + 1, visited))
                return true;
            visited[r - 1][c] = false;
        }
        if(c - 1 >= 0 && board[r][c - 1] == word.charAt(idx) && !visited[r][c - 1]){
            visited[r][c - 1] = true;
            if(boardContains(board, word, r, c - 1, idx + 1, visited))
                return true;
            visited[r][c - 1] = false;
        }
        if(r + 1 < board.length && board[r + 1][c] == word.charAt(idx) && !visited[r + 1][c]){
            visited[r + 1][c] = true;
            if(boardContains(board, word, r + 1, c, idx + 1, visited))
                return true;
            visited[r + 1][c] = false;
        }
        if(c + 1 < board[0].length && board[r][c + 1] == word.charAt(idx) && !visited[r][c + 1]){
            visited[r][c + 1] = true;
            if(boardContains(board, word, r, c + 1, idx + 1, visited))
                return true;
            visited[r][c + 1] = false;
        }
        return false;
    }
    
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    visited[i][j] = true;
                    if(boardContains(board, word, i, j, 1, visited))
                        return true;
                    visited[i][j] = false;
                }
            }
        }
        return false;
    }
}
