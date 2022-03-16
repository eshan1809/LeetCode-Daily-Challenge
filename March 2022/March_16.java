class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack<>();
        int i = 0, j = 0, n = pushed.length;
        while(i < n){
            while(!st.isEmpty() && st.peek() == popped[j]){
                st.pop();
                j++;
            }
            st.push(pushed[i++]);
        }
        while(!st.isEmpty() && st.peek() == popped[j]){
            st.pop();
            j++;
        }
        return st.isEmpty();
    }
}
