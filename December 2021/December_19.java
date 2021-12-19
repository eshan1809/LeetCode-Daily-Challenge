class Solution {
    public boolean isNum(String s){
        for(int i = 0; i < s.length(); i++)
            if(!Character.isDigit(s.charAt(i)))
                return false;
        return true;
    }
    public String decodeString(String s) {
        Stack<String> st = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == ']'){
                String str = "", lans = "";
                while(!st.peek().equals("["))
                    str = st.pop() + str;
                st.pop();
                int mul = 1;
                if(st.size() > 0 && isNum(st.peek()))
                    mul = Integer.parseInt(st.pop());
                while(mul-- > 0)
                    lans += str;
                st.push(lans);
            } else if(Character.isDigit(ch)){
                String add = "";
                if(st.size() > 0 && isNum(st.peek()))
                    add = st.pop();
                st.push(add + ch);
            } else
                st.push(ch + "");
        }
        String ans = "";
        while(st.size() > 0)
            ans = st.pop() + ans;
        return ans;
    }
}
