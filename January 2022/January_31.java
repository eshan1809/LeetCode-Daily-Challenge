class Solution {
    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for(int[] account : accounts){
            int amt = 0;
            for(int val : account)
                amt += val;
            max = Math.max(max, amt);
        }
        return max;
    }
}
