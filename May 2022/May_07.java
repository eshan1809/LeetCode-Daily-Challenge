class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        int[] min = new int[n];
        min[0] = nums[0];
        for(int i = 1; i < n; i++)
            min[i] = Math.min(min[i - 1], nums[i]);
        
        Stack<Integer> st = new Stack<>();
        for(int i = n - 1; i > 0; i--){
            while(!st.isEmpty() && st.peek() <= min[i])
                st.pop();
            if(!st.isEmpty() && nums[i] > st.peek())
                return true;
            st.add(nums[i]);
        }
        return false;
    }
} 
