class Solution {
    public boolean isPossible(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(1);
        int i = 1, n = nums.length;
        while(i < n && nums[i] == nums[0]){
            pq.add(1);
            i++;
        }
        while(i < n){
            int j = i;
            List<Integer> list = new ArrayList<>();
            while(j < n && nums[j] == nums[i - 1] + 1){
                if(!pq.isEmpty())
                    list.add(pq.remove() + 1);
                else
                    list.add(1);
                j++;
            }
            if(j == i)
                list.add(1);
            i = Math.max(j, i + 1);
            if(!pq.isEmpty() && pq.peek() < 3)
                return false;
            pq.clear();

            for(int v : list)
                pq.add(v);
        }
        if(!pq.isEmpty() && pq.peek() < 3)
            return false;
        return true;
    }
}
