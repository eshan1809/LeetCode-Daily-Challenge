class Solution {
    public int maxProfit(int[] prices) {
        int buy = prices[0], sell = 0, n = prices.length;
        for(int i = 0; i < n; i++){
            buy = Math.min(buy, prices[i]);
            sell = Math.max(sell, prices[i] - buy);
        }
        return sell;
    }
}
