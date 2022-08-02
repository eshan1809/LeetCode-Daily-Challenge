class Solution {
public:
    int find(vector<vector<int>> &matrix, int n, int k, int cap){
        int count = 0, ret = INT_MIN;
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
                ret = max(ret, matrix[i][ans]);
        }
        if(count < k)
            return -1;
        return ret;
    }
    
    int kthSmallest(vector<vector<int>>& matrix, int k) {
        int n = matrix.size(), lo = matrix[0][0], hi = matrix[n - 1][n - 1], ans = hi;
        while(lo <= hi){
            int mid = (lo + hi) / 2, val = find(matrix, n, k, mid);
            if(val != -1){
                ans = val;
                hi = mid - 1;
            } else
                lo = mid + 1;
        }
        return ans;
    }
};
