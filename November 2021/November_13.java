class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ngr = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = n - 1; i >= 0; i--){
            while(st.size() > 0 && temperatures[st.peek()] <= temperatures[i])
                st.pop();
            ngr[i] = st.size() == 0 ? 0 : st.peek() - i;
            st.push(i);
        }
        return ngr;
    }
}
