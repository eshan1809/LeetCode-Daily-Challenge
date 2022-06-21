class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i = 1;
        for(; pq.size() < ladders && i < heights.length; i++)
            if(heights[i] > heights[i - 1])
                pq.add(heights[i] - heights[i - 1]);
        for(; i < heights.length; i++){
            int diff = heights[i] - heights[i - 1];
            if(diff <= 0)
                continue;
            if(!pq.isEmpty() && pq.peek() < diff && bricks >= pq.peek()){
                bricks -= pq.remove();
                pq.add(diff);
            } else if(bricks >= diff)
                bricks -= diff;
            else
                return i - 1;
        }
        return heights.length - 1;
    }
}
