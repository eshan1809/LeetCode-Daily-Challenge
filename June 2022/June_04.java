class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] arr = new char[n][n];
        for(int i = 0; i < n; i++)
            Arrays.fill(arr[i], '.');
        list = new ArrayList<>();
        helper(arr, 0, n);
        return list;
    }
    
    List<List<String>> list;
    
    private void helper(char[][] arr, int i, int n){
        if(i == n){
            List<String> li = new ArrayList<>();
            for(var v : arr)
                li.add(String.valueOf(v));
            list.add(li);
            return;
        }
        
        for(int j = 0; j < n; j++)
            if(isSafe(i, j, arr, n)){
                arr[i][j] = 'Q';
                helper(arr, i + 1, n);
                arr[i][j] = '.';
            }
    }
    
    private boolean isSafe(int i, int j, char[][] arr, int n){
        int r = i - 1, c = j;
        while(r >= 0){
            if(arr[r][c] == 'Q')
                return false;
            r--;
        }
        
        r = i - 1;
        c = j - 1;
        while(r >= 0 && c >= 0){
            if(arr[r][c] == 'Q')
                return false;
            r--;
            c--;
        }
        
        r = i - 1;
        c = j + 1;
        while(r >= 0 && c < n){
            if(arr[r][c] == 'Q')
                return false;
            r--;
            c++;
        }
        
        return true;
    }
}
