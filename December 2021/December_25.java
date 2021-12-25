class Solution {
    public int calculate(String s) {
        int n = s.length(), currNum = 0, prevNum = 0, ans = 0;
        char op = '+';
        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch))
                currNum = currNum * 10 + (ch - '0');
            if(!Character.isDigit(ch) && ch != ' ' || i == n - 1){
                if(op == '+' || op == '-'){
                    ans += prevNum;
                    prevNum = op == '+' ? currNum : -currNum;
                } else if(op == '*')
                    prevNum *= currNum;
                else if(op == '/')
                    prevNum /= currNum;
                op = ch;
                currNum = 0;
            }
        }
        return ans + prevNum;
    }
}
