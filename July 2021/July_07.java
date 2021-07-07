class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length, lo = matrix[0][0], hi = matrix[n-1][n-1];
        while(lo < hi){
            int mid = (lo + hi) / 2;
            int count = count(matrix, mid);
            if(count < k) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
    
    public int count(int[][] matrix, int mid){
        int count = 0;   
        for(int i = 0; i < matrix.length; i++)
            for(int j = matrix[i].length - 1; j >= 0; j--)
                if(matrix[j][i] <= mid){
                    count += j + 1;
                    break;
                }
        return count;
    }
}
