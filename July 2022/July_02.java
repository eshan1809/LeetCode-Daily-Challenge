class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int n = horizontalCuts.length, m = verticalCuts.length;
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int x = Math.max(horizontalCuts[0], h - horizontalCuts[n - 1]);
        for(int i = 1; i < n; i++)
            x = Math.max(x, horizontalCuts[i] - horizontalCuts[i - 1]);
        int y = Math.max(verticalCuts[0], w - verticalCuts[m - 1]);
        for(int i = 1; i < m; i++)
            y = Math.max(y, verticalCuts[i] - verticalCuts[i - 1]);
        return (int)((1L * x * y) % 1000000007);
    }
}
