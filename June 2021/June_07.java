class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] kharcha = new int[cost.length];
        kharcha[0] = cost[0];
        kharcha[1] = cost[1];
        for(int i = 2; i < cost.length; i++)
            kharcha[i] = cost[i] + Math.min(kharcha[i - 1], kharcha[i - 2]);
        return Math.min(kharcha[kharcha.length - 1], kharcha[kharcha.length - 2]);
    }
}
