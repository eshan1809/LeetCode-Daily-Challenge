class Solution {
    public int jump(int[] nums) {
        if(nums.length <= 1 || nums[0] == 0) return 0;	
        int x = nums[0], y = nums[0], j = 1;
        for(int i = 1; i < nums.length; i++){
            x = Math.max(x, nums[i] + i);
            if(y == nums.length - 1) return j;
            if(y == i){
                j++;
                y = x;
            }
        }
        return j;
    }
}
