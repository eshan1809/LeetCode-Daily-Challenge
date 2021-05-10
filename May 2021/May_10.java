class Solution {
    public int countPrimes(int n) {
        int count = 0;
        boolean[] dp = new boolean[n];
        for(int i = 2; i <= (int)Math.sqrt(n); i++)
            if(!dp[i])
                for (int j = i*i; j < n; j += i) dp[j] = true;
        for (int i = 2; i < n; i++) if (!dp[i]) count++;
        return count;
    }
}
