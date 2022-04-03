class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length, lo = 0;
        for(int i = n - 2; i >= 0; i--){
            if(nums[i] < nums[i + 1]){
                for(int j = n - 1; j > i; j--){
                    if(nums[j] > nums[i]){
                        swap(nums, i, j);
                        lo = i + 1;                       
                        break;
                    }
                }
            }
            if(lo == i + 1)
                break;
        }
        reverse(nums, lo, n - 1);
    }
    
    private void reverse(int[] nums, int lo, int hi){
        while(lo < hi)
            swap(nums, lo++, hi--);
    }
    
    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
