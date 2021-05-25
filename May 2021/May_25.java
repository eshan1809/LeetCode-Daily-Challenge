class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(String token : tokens){
            if(token.equals("+")){
                int o2 = st.pop(), o1 = st.pop();
                st.push(o1 + o2);
            } else if(token.equals("-")){
                int o2 = st.pop(), o1 = st.pop();
                st.push(o1 - o2);
            } else if(token.equals("*")){
                int o2 = st.pop(), o1 = st.pop();
                st.push(o1 * o2);
            } else if(token.equals("/")){
                int o2 = st.pop(), o1 = st.pop();
                st.push(o1 / o2);
            } else st.push(Integer.parseInt(token));
        }
        return st.pop();
    }
}
