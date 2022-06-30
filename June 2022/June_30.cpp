class Solution {
public:
    int minMoves2(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        int n = nums.size();
        long sum[n + 1];
        sum[0] = 0;
        for(int i = 0; i < n; i++)
            sum[i + 1] = sum[i] + nums[i];
        long ans = INT_MAX;
        for(int i = 0; i < n; i++){
            long a1 = 1ll * i * nums[i] - sum[i], a2 = sum[n] - sum[i + 1] - 1ll * (n - i - 1) * nums[i];
            ans = min(ans, a1 + a2);
        }
        return (int)ans;
    }
};
