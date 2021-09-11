class Solution {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        int op = 0, ans = 0 , sign = 1;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '+'){
                ans += sign * op;
                sign = 1;
                op = 0;
            } else if(ch == '-'){
                ans += sign * op;
                sign = -1;
                op = 0;
            } else if(ch == '('){
                st.push(ans);
                st.push(sign);
                sign = 1;
                ans = 0;
            } else if(ch == ')'){
                ans += sign * op;
                ans *= st.pop();
                ans += st.pop();
                op = 0;
            } else if(ch == ' ') continue;
            else op = op * 10 + (int)(ch - '0');
        }
        return ans + sign * op;
    }
}
