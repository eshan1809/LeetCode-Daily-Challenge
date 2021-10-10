class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int ans = 0;
        for(int i = 0; i < 31; i++){
            int x = (1 << i);
            int l = ((left - x) / (x * 2)) * (x * 2) + x, r = l + x - 1;
            if(left >= l && right <= r)
                ans += x;
        }
        return ans;
    }
}
