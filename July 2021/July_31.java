class Solution {
    public int trap(int[] height) {
        int n = height.length, max = 0, ans = 0;
        int[] maxL = new int[n], maxR = new int[n];
        for(int i = 0; i < n; i++){
            max = Math.max(max, height[i]);
            maxL[i] = max;
        }
        max = 0;
        for(int i = n - 1; i >= 0; i--){
            max = Math.max(max, height[i]);
            maxR[i] = max;
        }
        for(int i = 0; i < n; i++)
            ans += Math.min(maxL[i], maxR[i]) - height[i];
        return ans;
    }
}
