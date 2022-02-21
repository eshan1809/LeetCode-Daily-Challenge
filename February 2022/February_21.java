class Solution {
    public int majorityElement(int[] nums) {
        int maj = nums[0], freq = 1;
        for(int i = 1; i < nums.length; i++){
            if(maj == nums[i])
                freq++;
            else{
                if(freq == 0){
                    maj = nums[i];
                    freq = 1;
                } else{
                    freq--;
                }
            }
        }
        return maj;
    }
}
