class Solution {
public:
    int concatenatedBinary(int n) {
        int mod = (int)(1e9 + 7);
        long long ans = 0ll;
        for(int i = 1; i <= n; i++){
            ans <<= ((int)log2(i) + 1);
            ans %= mod;
            ans += i;
            ans %= mod;
        }
        return (int) ans;
    }
};
