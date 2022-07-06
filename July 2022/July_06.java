class Solution {
    public int fib(int n) {
        if(n <= 1)
            return n;
        int f = 0, s = 1;
        for(int i = 2; i <= n; i++){
            int c = f + s;
            f = s;
            s = c;
        }
        return s;
    }
}
