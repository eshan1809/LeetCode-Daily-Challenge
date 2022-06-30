class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        long[] sum = new long[n + 1];
        for(int i = 0; i < n; i++)
            sum[i + 1] = sum[i] + nums[i];
        long ans = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            long a1 = 1L * i * nums[i] - sum[i], a2 = sum[n] - sum[i + 1] - 1L * (n - i - 1) * nums[i];
            ans = Math.min(ans, a1 + a2);
        }
        return (int)ans;
    }
}
