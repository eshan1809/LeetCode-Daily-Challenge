class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        int n = arr.length, mod = (int)(1e9 + 7);
        Arrays.sort(arr);
        int[] dp = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            dp[i] = 1;
            map.put(arr[i], i);
        }
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(arr[i] % arr[j] == 0){
                    int f = arr[i] / arr[j];
                    if(map.containsKey(f)){
                        dp[i] += (int)((1L * dp[j] * dp[map.get(f)]) % mod);
                        dp[i] %= mod;
                    }
                }
            }
        }
        int ans = 0;
        for(int i = 0; i < n; i++){
            ans += dp[i];
            ans %= mod;
        }
        return ans;
    }
}
