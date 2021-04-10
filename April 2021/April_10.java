class Solution{
    int arr1[] = {0,1,0,-1}, arr2[] = {1,0,-1,0};
    int dp[][];
    public int longestIncreasingPath(int[][] matrix) {
        dp = new int[matrix.length][matrix[0].length];
        int max = 1;
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        for(int i = 0; i < matrix.length; i++)
            for(int j = 0; j < matrix[0].length; j++)
                max = Math.max(max, longestPath(matrix, i, j, dp)); 
        return max;   
    }
    
    public int longestPath(int matrix[][], int i, int j, int dp[][]){
        if(dp[i][j] != 0) return dp[i][j];
        int max = 1;
        for(int p = 0; p < arr1.length; p++){
            int ni = i + arr1[p], nj = j + arr2[p];
            if(isSafe(matrix, ni, nj) && matrix[ni][nj] > matrix[i][j]){
                max = Math.max(max, 1 + longestPath(matrix, ni, nj, dp));
                dp[i][j] = max;
            }
        }
        return max;
    }
    public boolean isSafe(int matrix[][], int i, int j){
        if(i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length) return true;
        return false;
    }
}
