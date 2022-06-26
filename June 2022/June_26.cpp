class Solution {
public:
    int maxScore(vector<int>& cardPoints, int k) {
        int mx = 0, n = cardPoints.size();
        for(int i = 0; i < k; i++)
            mx += cardPoints[i];
        int curr = mx;
        for(int i = k - 1, j = n - 1; i >= 0; i--, j--){
            curr += cardPoints[j] - cardPoints[i];
            mx = max(mx, curr);
        }
        return mx;
    }
};
