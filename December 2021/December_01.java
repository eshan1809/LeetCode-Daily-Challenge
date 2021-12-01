class Solution {
    public int rob(int[] nums) {
        int prevStolen = nums[0], prevNotStolen = 0;
        for(int i = 1; i < nums.length; i++){
            int currStolen = prevNotStolen + nums[i];
            prevNotStolen = Math.max(prevStolen, prevNotStolen);
            prevStolen = currStolen;
        }
        return Math.max(prevStolen, prevNotStolen);
    }
}
