class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int n = nums.length, i = 0, j = n - 1;
        int[] ans = new int[n];
        for(int k = 0; k < n; k++){
            if((nums[k] & 1) == 0)
                ans[i++] = nums[k];
            else
                ans[j--] = nums[k];
        }
        return ans;
    }
}
