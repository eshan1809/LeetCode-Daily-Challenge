class Solution {
    public int[] nextGreaterElement(int[] query, int[] nums) {
        Stack<Integer> st = new Stack<>();
        Map<Integer, Integer> map = new HashMap();
        for(int i = nums.length - 1; i >= 0; i--){
            while(st.size() > 0 && st.peek() <= nums[i])
                st.pop();
            if(st.size() == 0)
                map.put(nums[i], -1);
            else
                map.put(nums[i], st.peek());
            st.push(nums[i]);
        }
        int[] ret = new int[query.length];
        for(int i = 0; i < ret.length; i++)
            ret[i] = map.get(query[i]);
        return ret;
    }
}
