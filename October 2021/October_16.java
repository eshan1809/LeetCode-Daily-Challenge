class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length, min = prices[0], max = prices[n - 1], ans = 0;
        int[] sell = new int[n], buy = new int[n];
        for(int i = 1; i < n; i++){
            min = Math.min(min, prices[i]);
            sell[i] = Math.max(sell[i - 1], prices[i] - min);
        }
        for(int i = n - 2; i >= 0; i--){
            max = Math.max(max, prices[i]);
            buy[i] = Math.max(buy[i + 1], max - prices[i]);
            ans = Math.max(ans, sell[i] + buy[i]);
        }
        return ans;
    }
}
