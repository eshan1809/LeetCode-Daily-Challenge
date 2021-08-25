class Solution {
    public boolean judgeSquareSum(int c) {
        int i = 0, j = (int)Math.floor(Math.sqrt(c));
        while(i <= j){
            int a = i * i, b = j * j;
            if(a + b > c)
                j--;
            else if(a + b < c)
                i++;
            else
                return true;
        }
        return false;
    }
}
