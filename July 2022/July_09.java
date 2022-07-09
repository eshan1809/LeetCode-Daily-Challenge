class Solution {
    public int maxResult(int[] nums, int k) {
        int n = nums.length, i = n - 1, max = (int) 1e9, j;
        int[] dp = new int[n];
        dp[i] = nums[i];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(dp[i], 1);
        for(i = n - 2, j = 1; i >= 0 && j <= k; i--, j++){
            Integer key = map.floorKey(max);
            dp[i] = nums[i] + key;
            map.put(dp[i], map.getOrDefault(dp[i], 0) + 1);
        }
        while(i >= 0){
            int f = map.get(dp[i + k + 1]);
            if(f == 1)
                map.remove(dp[i + k + 1]);
            else
                map.put(dp[i + k + 1], map.getOrDefault(dp[i + k + 1], 0) - 1);
            Integer key = map.floorKey(max);
            dp[i] = nums[i] + key;
            map.put(dp[i], map.getOrDefault(dp[i], 0) + 1);
            i--;
        }
        return dp[0];
    }
}
