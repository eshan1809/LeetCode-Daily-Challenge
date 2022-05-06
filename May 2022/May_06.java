class Solution {
    public String removeDuplicates(String s, int k) {
        int n = s.length();
        Stack<Character> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        for(int i = 0; i < n; i++){
            if(!st1.isEmpty() && st1.peek() == s.charAt(i))
                st2.push(st2.peek() + 1);
            else
                st2.push(1);
            st1.push(s.charAt(i));
            if(st2.peek() == k){
                for(int j = 0; j < k; j++){
                    st1.pop();
                    st2.pop();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!st1.isEmpty())
            sb.append(st1.pop());
        return sb.reverse().toString();
    }
}
