class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 1, prev = nums[0], ans = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == prev){
                count++;
                if(count <= 2)
                    nums[ans++] = prev;
            } else{
                prev = nums[i];
                count = 1;
                nums[ans++] = prev;
            }
        }
        return ans;
    }
}
