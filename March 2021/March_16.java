class Solution {
    public int maxProfit(int[] prices, int fee) {
        int bsp = 0, ssp = 0;
        if(prices.length > 0) bsp = -prices[0];
        for(int i = 1; i < prices.length; i++){
            int nbsp = ssp - prices[i], nssp = bsp + prices[i] - fee;
            ssp = Math.max(ssp, nssp);
            bsp = Math.max(bsp, nbsp);
        }
        return ssp;
    }
}
