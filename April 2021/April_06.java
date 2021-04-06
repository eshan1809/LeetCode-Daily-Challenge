class Solution {
    public int minOperations(int n) {
        int ans = 0;
        for(int i=2; i<=n; i++) ans += i/2;
        return ans;
    }
}
