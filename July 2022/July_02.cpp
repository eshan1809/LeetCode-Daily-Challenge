class Solution {
public:
    int maxArea(int h, int w, vector<int>& horizontalCuts, vector<int>& verticalCuts) {
        sort(horizontalCuts.begin(), horizontalCuts.end());
        sort(verticalCuts.begin(), verticalCuts.end());
        int n = horizontalCuts.size(), m = verticalCuts.size();
        int x = max(horizontalCuts[0], h - horizontalCuts[n - 1]);
        for(int i = 1; i < n; i++)
            x = max(x, horizontalCuts[i] - horizontalCuts[i - 1]);
        int y = max(verticalCuts[0], w - verticalCuts[m - 1]);
        for(int i = 1; i < m; i++)
            y = max(y, verticalCuts[i] - verticalCuts[i - 1]);
        return (int)((1ll * x * y) % 1000000007);
    }
};
