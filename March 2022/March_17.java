class Solution {
    public int scoreOfParentheses(String s) {
        // representing "(" -> -1
        Stack<Integer> st = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch == '(')
                st.push(-1);
            else{
                if(st.peek() == -1){
                    st.pop();
                    st.push(1);
                } else{
                    int num = st.pop();
                    st.pop();
                    st.push(2 * num);
                }
                int num = st.pop();
                while(!st.isEmpty() && st.peek() != -1)
                    num += st.pop();
                st.push(num);
            }
        }
        return st.pop();
    }
}
