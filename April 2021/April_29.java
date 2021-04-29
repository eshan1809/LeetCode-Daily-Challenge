class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] arr = new int[]{-1, -1};
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target){
                if(arr[0] == -1){
                    arr[0] = i;
                    arr[1] = i;
                } else arr[1] = i;
            } else if(arr[1] != -1) break;
        }
        return arr;
    }
}
