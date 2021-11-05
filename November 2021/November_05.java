class Solution {
    public int arrangeCoins(int n) {
        int sub = 1;
        while(n >= sub){
            n -= sub;
            sub++;
        }
        return sub - 1;
    }
}
