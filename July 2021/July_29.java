class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int[][] res = new int[n][m];
        for(int i = 0; i < n; i++)
            Arrays.fill(res[i], 1000000);
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mat[i][j] == 0)
                    res[i][j] = 0;
                else{
                    if(i > 0) res[i][j] = Math.min(res[i][j], res[i - 1][j] + 1);
                    if(j > 0) res[i][j] = Math.min(res[i][j], res[i][j - 1] + 1);
                }
            }
        }
            
        for(int i = n - 1; i >= 0; i--){
            for(int j = m - 1; j >= 0; j--){
                if(i < n - 1) res[i][j] = Math.min(res[i][j], res[i + 1][j] + 1);
                if(j < m - 1) res[i][j] = Math.min(res[i][j], res[i][j + 1] + 1);
            }
        }
        
        return res;
    }
}
