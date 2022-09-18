class Solution {
public:
    int trap(vector<int>& height) {
        int n = height.size();
        int lg[n], rg[n];
        lg[0] = height[0];
        for(int i = 1; i < n; i++)
            lg[i] = max(lg[i - 1], height[i]);
        rg[n - 1] = height[n - 1];
        for(int i = n - 2; i >= 0; i--)
            rg[i] = max(rg[i + 1], height[i]);
        int ans = 0;
        for(int i = 0; i < n; i++)
            ans += min(rg[i], lg[i]) - height[i];
        return ans;
    }
};
