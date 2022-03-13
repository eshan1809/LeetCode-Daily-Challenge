class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        if((n & 1) == 1)
            return false;
        Stack<Character> st = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch == '(' || ch == '{' || ch == '[')
                st.push(ch);
            else if(!st.isEmpty() && ch == ')' && st.peek() == '(')
                st.pop();
            else if(!st.isEmpty() && ch == ']' && st.peek() == '[')
                st.pop();
            else if(!st.isEmpty() && ch == '}' && st.peek() == '{')
                st.pop();
            else
                return false;
        }
        return st.isEmpty();
    }
}
