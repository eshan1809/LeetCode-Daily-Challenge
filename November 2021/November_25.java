class Solution {
    public int maxSubArray(int[] nums) {
        int cm = nums[0], om = nums[0];
        for(int i = 1; i < nums.length; i++){
            cm = Math.max(cm + nums[i], nums[i]);
            om = Math.max(om, cm);
        }
        return om;
    }
}
