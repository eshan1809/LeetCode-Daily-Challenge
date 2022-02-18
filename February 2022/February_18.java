class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < num.length(); i++){
            int x = num.charAt(i) - '0';
            while(st.size() > 0 && st.peek() > x && k > 0){
                st.pop();
                k--;
            }
            st.push(x);
        }
        while (k > 0 && st.size() > 0) {
            st.pop();
            k--;
        }
        StringBuilder ans = new StringBuilder();
        while (st.size() > 0)
            ans.append(st.pop());
        ans = ans.reverse();
        int i = 0;
        while (i < ans.length() && ans.charAt(i) == '0')
            i++;
        return i == ans.length() ? "0" : ans.substring(i).toString();
    }
}
