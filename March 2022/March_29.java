class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length, i = 0;
        while(nums[i] > 0){
            nums[i] *= -1;
            i = -nums[i];
        }
        int ans = i;
        for(i = 0; i < n; i++)
            if(nums[i] < 0)
                nums[i] *= -1;
        return ans;
    }
}
