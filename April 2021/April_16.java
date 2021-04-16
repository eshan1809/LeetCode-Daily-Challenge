class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Character> st1 = new Stack();
        Stack<Integer> st2 = new Stack();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(st1.size() > 0 && st1.peek() == ch) st2.push(st2.peek() + 1);
            else st2.push(1);
            st1.push(ch);
            if(st2.peek() == k){
                for(int j = 0; j < k; j++){
                    st1.pop();
                    st2.pop();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while(st1.size() > 0) sb.append(st1.pop());
        return sb.reverse().toString();
    }
}
