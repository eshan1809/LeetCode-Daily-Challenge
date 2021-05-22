class Solution {
    List<List<String>> list;
    public List<List<String>> solveNQueens(int n) {
        list = new ArrayList<>();
        boolean[][] placed = new boolean[n][n];
        helper(0, n, placed);
        return list;
    }
    public void helper(int i, int n, boolean[][] placed) {
        if(i == n){
            List<String> al = new ArrayList<>();
            for(int x = 0; x < n; x++){
                String str = "";
                for(int y = 0; y < n; y++){
                    if(placed[x][y]) str += 'Q';
                    else str += '.';
                }
                al.add(str);
            }
            list.add(al);
            return;
        }
        for(int j = 0; j < n; j++){
            if(isSafe(i, j, placed)){
                placed[i][j] = true;
                helper(i+1, n, placed);
                placed[i][j] = false;
            }
        }
    }
    public boolean isSafe(int i, int j, boolean[][] placed){
        for(int x = i-1; x >= 0; x--) if(placed[x][j]) return false;
        for(int x = i-1, y = j-1; x >= 0 && y >= 0; x--, y--) if(placed[x][y]) return false;
        for(int x = i-1, y = j+1; x >= 0 && y < placed.length; x--, y++) if(placed[x][y]) return false;
        return true;
    }
}
