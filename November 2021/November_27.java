class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        ans[0] = 1;
        int lm = 1, rm = 1;
        for(int i = 0; i < nums.length; i++){
            ans[i] = lm;
            lm *= nums[i];
        }
        for(int i = nums.length - 1; i >= 0; i--){
            ans[i] *= rm;
            rm *= nums[i];
        }
        return ans;
    }
}
