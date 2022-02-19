class Solution {
    public int minimumDeviation(int[] nums) {
        int min = Integer.MAX_VALUE, ans = Integer.MAX_VALUE;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : nums){
            if((i & 1) == 1){
                pq.add(2 * i);
                min = Math.min(min, 2 * i);
            }
            else{
                pq.add(i);
                min = Math.min(min, i);
            }
        }
        while((pq.peek() & 1) == 0){
            int rem = pq.remove();
            ans = Math.min(ans, rem - min);
            min = Math.min(min, (rem >> 1));
            pq.add(rem >> 1);
        }
        ans = Math.min(ans, pq.peek() - min);;
        return ans;
    }
}
