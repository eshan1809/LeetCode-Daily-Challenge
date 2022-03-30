class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        int lo = 0, hi = n * m - 1;
        while(lo <= hi){
            int mid = (lo + hi) / 2;
            int r = mid / m, c = mid % m;
            if(target == matrix[r][c])
                return true;
            else if(target < matrix[r][c])
                hi = mid - 1;
            else
                lo = mid + 1;
        }
        return false;
    }
}
