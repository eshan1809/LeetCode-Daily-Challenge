class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n], right = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i])
                st.pop();
            if(st.isEmpty())
                left[i] = -1;
            else
                left[i] = st.peek();
            st.push(i);
        }
        st = new Stack<>();
        for(int i = n - 1; i >= 0; i--){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i])
                st.pop();
            if(st.isEmpty())
                right[i] = n;
            else
                right[i] = st.peek();
            st.push(i);
        }
        int max = 0;
        for(int i = 0; i < n; i++){
            max = Math.max(max, heights[i] * (right[i] - left[i] - 1));
        }
        return max;
    }
}
