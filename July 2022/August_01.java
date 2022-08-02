class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length, lo = matrix[0][0], hi = matrix[n - 1][n - 1], ans = hi;
        while(lo <= hi){
            int mid = (lo + hi) / 2, val = find(matrix, mid, n, k);
            if(val != -1){
                ans = val;
                hi = mid - 1;
            } else
                lo = mid + 1;
        }
        return ans;
    }
    
    public int find(int[][] matrix, int cap, int n, int k){
        int count = 0, ret = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            int lo = 0, hi = n - 1, ans = -1;
            while(lo <= hi){
                int mid = (lo + hi) / 2;
                if(matrix[i][mid] <= cap){
                    ans = mid;
                    lo = mid + 1;
                } else
                    hi = mid - 1;
            }
            count += ans + 1;
            if(ans != -1)
                ret = Math.max(ret, matrix[i][ans]);
        }
        if(count < k)
            return -1;
        return ret;
    }
}
