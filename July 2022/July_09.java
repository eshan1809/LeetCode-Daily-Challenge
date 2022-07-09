class Solution {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        int[] dp = new int[n];
        dp[n - 1] = nums[n - 1];
        pq.add(new int[]{dp[n - 1], n - 1});
        for(int i = n - 2; i >= 0; i--){
            while(pq.peek()[1] > i + k)
                pq.remove();
            dp[i] = nums[i] + pq.peek()[0];
            pq.add(new int[]{dp[i], i});
        }
        return dp[0];
    }
}
