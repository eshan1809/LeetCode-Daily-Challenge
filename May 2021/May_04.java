class Solution {
    public boolean checkPossibility(int[] nums) {
        int count = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i-1] > nums[i]){
                count++;
                if(i-2 >= 0 && i+1 < nums.length){
                    if(nums[i-2] > nums[i] && nums[i-1] > nums[i+1]) return false;
                }
                if(count > 1) return false;
            }
        }
        return true;
    }
}
