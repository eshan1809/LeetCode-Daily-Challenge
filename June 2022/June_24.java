class Solution {
    public boolean isPossible(int[] target) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long sum = 0L;
        for(int i : target){
            sum += i;
            pq.add(i);
        }
        while(!pq.isEmpty()){
            int rem = pq.remove();
            sum -= rem;
            if(rem == 1 || sum == 1)
                return true;
            if(rem < sum || sum == 0 || rem % sum == 0)
                return false;
            rem %= sum;
            pq.add(rem);
            sum += rem;
        }
        return true;
    }
}
