class Solution {
    public int longestOnes(int[] nums, int k) {
        int curr = 0, ans = 0, n = nums.length;
        for(int i = 0; i < n; i++){
            if(nums[i] == 0){
                if(k == 0){
                    while(nums[curr] != 0) curr++;
                    curr++;
                } else k--;
            }
            ans = Math.max(ans, i - curr + 1);
        }
        return ans;
    }
}
