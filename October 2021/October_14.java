class Solution {
    public int helper(int n, List<Integer> list, int idx, Integer[] dp){
        if(dp[n] != null)
            return dp[n];
        int min = n;
        for(int i = idx; i >= 0; i--)
            if(list.get(i) <= n)
                min = Math.min(min, 1 + helper(n - list.get(i), list, i, dp));
        dp[n] = min;
        return min;
    }
    
    public int numSquares(int n) {
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i * i <= n; i++)
            list.add(i * i);
        Integer[] dp = new Integer[n + 1];
        for(int i = 1; i <= n; i++)
            helper(i, list, list.size() - 1, dp);
        return dp[n];
    }
}
