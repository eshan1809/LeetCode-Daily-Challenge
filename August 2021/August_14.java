class Solution {
    private int helper(int[] boxes, int i, int j, int k, int[][][] dp) {
        if(i > j)
            return 0;
        if(dp[i][j][k] > 0)
            return dp[i][j][k];
    
        int ti = i, tk = k;
        while(i + 1 <= j && boxes[i + 1] == boxes[i]){
            i++;
            k++;
        }
        
        int res = (k + 1) * (k + 1) + helper(boxes, i + 1, j, 0, dp);
        for(int m = i + 1; m <= j; m++)
            if(boxes[i] == boxes[m])
                res = Math.max(res, helper(boxes, i + 1, m - 1, 0, dp) + helper(boxes, m, j, k + 1, dp));

        dp[ti][j][tk] = res;
        return res;
    }
    
    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        return helper(boxes, 0, n - 1, 0, new int[n][n][n]);
    }
}
