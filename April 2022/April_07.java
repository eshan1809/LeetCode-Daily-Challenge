class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : stones)
            pq.add(i);
        while(pq.size() > 1){
            int y = pq.remove(), x = pq.remove();
            if(x < y)
                pq.add(y - x);
        }
        if(pq.isEmpty())
            return 0;
        return pq.remove();
    }
}
