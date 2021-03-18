class Solution {
    int ans = 10001;
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        fun(amount, 0, coins.length-1, coins);
        return ans < 10001 ? ans : -1;
    }
    
    void fun(int amt, int num, int cix, int[] C) {
        if (amt == 0) ans = Math.min(num, ans);
        else if (amt > 0 && cix >= 0) {
            int n = amt / C[cix];
            if (n + num >= ans) return;
            while (n >= 0) fun(amt - n * C[cix], num + n--, cix - 1, C);
        }
    }
}
