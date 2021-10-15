class Solution {
    public int maxProfit(int[] prices) {
        int bsp = -prices[0], ssp = 0, csp = 0;
        for(int i = 0; i < prices.length; i++){
            int nbsp = 0, nssp = 0, ncsp = 0;
            if(csp - prices[i] > bsp)
                nbsp = csp - prices[i];
            else
                nbsp = bsp;
            if(bsp + prices[i] > ssp)
                nssp = bsp + prices[i];
            else
                nssp = ssp;
            if(ssp > csp)
                ncsp = ssp;
            else
                ncsp = csp;
            bsp = nbsp;
            ssp = nssp;
            csp = ncsp;
        }
        return ssp;
    }
}
