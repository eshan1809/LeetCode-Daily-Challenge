class Solution {
public:
    int numFactoredBinaryTrees(vector<int>& arr) {
        int n = arr.size(), mod = (int)(1e9 + 7);
        sort(arr.begin(), arr.end());
        int dp[n];
        map<int, int> mp;
        for(int i = 0; i < n; i++){
            dp[i] = 1;
            mp[arr[i]] = i;
        }
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(arr[i] % arr[j] == 0){
                    int f = arr[i] / arr[j];
                    if(mp.find(f) != mp.end()){
                        dp[i] += (int)((1L * dp[j] * dp[mp[f]]) % mod);
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
};
