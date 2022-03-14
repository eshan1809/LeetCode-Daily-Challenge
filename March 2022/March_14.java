class Solution {
    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        for(String s : path.split("/")){
            if(!st.isEmpty() && s.equals(".."))
                st.pop();
            else if(!s.equals(".") && !s.equals("") && !s.equals(".."))
                st.push(s);
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty())
            sb.insert(0, "/" + st.pop());
        if(sb.isEmpty())
            sb.append('/');
        return sb.toString();
    }
}
