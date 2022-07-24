class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        int r = 0, c = m - 1;
        while(r < n && c >= 0){
            if(matrix[r][c] == target)
                return true;
            else if(matrix[r][c] < target)
                r++;
            else
                c--;
        }
        return false;
    }
}
