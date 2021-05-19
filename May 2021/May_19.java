class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1, ans = 0;        
        while(i < j) ans += nums[j--] - nums[i++];
        return ans;
    }
}
