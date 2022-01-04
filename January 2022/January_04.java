class Solution {
    public int number(int num){
        int count = 0;
        while(num > 0){
            count++;
            num >>= 1;
        }
        return count;
    }
    public int bitwiseComplement(int n) {
        if(n == 0)
            return 1;
        int count = number(n);
        int mask = (1 << count) - 1;
        return n ^ mask;
    }
}
