class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        size = strs.length;
        arr = new int[size][2];
        for(int i = 0; i < size; i++){
            for(int j = 0; j < strs[i].length(); j++){
                if(strs[i].charAt(j) == '0')
                    arr[i][0]++;
                else
                    arr[i][1]++;
            }
        }
        dp = new Integer[size][m + 1][n + 1];
        return helper(0, m, n);
    }
    
    int[][] arr;
    int size;
    Integer[][][] dp;
    
    private int helper(int i, int m, int n){
        if(i == size)
            return 0;
        if(dp[i][m][n] != null)
            return dp[i][m][n];
        int ans = helper(i + 1, m, n);
        if(arr[i][0] <= m && arr[i][1] <= n)
            ans = Math.max(ans, 1 + helper(i + 1, m - arr[i][0], n - arr[i][1]));
        return dp[i][m][n] = ans;
    }
}
