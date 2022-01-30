class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        if(k != 0){
            reverse(nums, 0, n - k - 1);
            reverse(nums, n - k, n - 1);
            reverse(nums, 0, n - 1);
        }
    }
    
    private void reverse(int[] nums, int s, int e){
        while(s < e){
            int tmp = nums[s];
            nums[s++] = nums[e];
            nums[e--] = tmp;
        }
    }
}
