class Solution {
    public int findComplement(int num) {
        int x = 0, n = num;
        while(n > 0){
            x++;
            n >>= 1;
        }
        return num ^ ((1 << x) - 1);
    }
}
