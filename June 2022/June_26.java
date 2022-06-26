class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int max = 0, n = cardPoints.length;
        for(int i = 0; i < k; i++)
            max += cardPoints[i];
        int curr = max;
        for(int i = k - 1, j = n - 1; i >= 0; i--, j--){
            curr += cardPoints[j] - cardPoints[i];
            max = Math.max(max, curr);
        }
        return max;
    }
}
