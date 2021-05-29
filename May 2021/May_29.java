class Solution {
    int count;
    public int totalNQueens(int n) {
        boolean[][] queen = new boolean[n][n];
        count = 0;
        helper(0, n, queen);
        return count;
    }
    public void helper(int l, int n, boolean[][] queen){
        if(l == n){
            count++;
            return;
        }
        
        for(int i=0; i<queen.length; i++){
            if(isSafe(l, i, queen)){
                queen[l][i] = true;
                helper(l+1, n, queen);
                queen[l][i] = false;
            }
        }
    }
    public boolean isSafe(int i, int j, boolean[][] queen){
        int r = i-1, c = j;
        while(r >= 0) if(queen[r--][c]) return false;
        r = i-1;
        c = j-1;
        while(r >= 0 && c >= 0) if(queen[r--][c--]) return false;
        r = i-1;
        c = j+1;
        while(r >= 0 && c < queen.length) if(queen[r--][c++]) return false;
        return true;
    }
}
