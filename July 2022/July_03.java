class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length, curr = nums[0], len = 1;
        boolean up = false, down = false;
        for(int i = 1; i < n; i++){
            if(nums[i] > curr){
                if(!up){
                    up = true;
                    down = false;
                    len++;
                }
                curr = nums[i];
            } else if(nums[i] < curr){
                if(!down){
                    down = true;
                    up = false;
                    len++;
                }
                curr = nums[i];
            }
        }
        return len;
    }
}
