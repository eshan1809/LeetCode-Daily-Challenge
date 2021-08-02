class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length, lo = 0, hi = n - 1;
        int[][] arr = new int[n][2];
        for(int i = 0; i < n; i++){
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        int[] ans = new int[2];
        while(lo < hi){
            int val = arr[lo][0] + arr[hi][0];
            if(val > target)
                hi--;
            else if(val < target)
                lo++;
            else{
                ans[0] = arr[lo][1];
                ans[1] = arr[hi][1];
                break;
            }
        }
        return ans;
    }
}
