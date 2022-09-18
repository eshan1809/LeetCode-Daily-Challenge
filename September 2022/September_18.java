class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] lg = new int[n], rg = new int[n];
        lg[0] = height[0];
        for(int i = 1; i < n; i++)
            lg[i] = Math.max(lg[i - 1], height[i]);
        rg[n - 1] = height[n - 1];
        for(int i = n - 2; i >= 0; i--)
            rg[i] = Math.max(rg[i + 1], height[i]);
        int ans = 0;
        for(int i = 0; i < n; i++)
            ans += Math.min(rg[i], lg[i]) - height[i];
        return ans;
    }
}
