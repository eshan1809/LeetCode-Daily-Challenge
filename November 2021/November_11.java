class Solution {
    public int minStartValue(int[] nums) {
        int[] arr = new int[nums.length];
        arr[0] = nums[0];
        int min = Math.min(0, arr[0]);
        for(int i = 1; i < nums.length; i++){
            arr[i] = arr[i - 1] + nums[i];
            min = Math.min(min, arr[i]);
        }
        return Math.abs(min) + 1;
    }
}
