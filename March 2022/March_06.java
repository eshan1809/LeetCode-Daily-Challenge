class Solution {
    public int countOrders(int n) {
        int prev = 1;
        int mod = (int)1e9 + 7;
        for(int i = 2; i <= n; i++){
            int brac = 2 * (i - 1);
            long curr = 1L * prev * (brac + 1) * (brac + 2) / 2;
            prev = (int)(curr % mod);
        }
        return prev;
    }
}
