class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums)
            map.put(i, map.getOrDefault(i, 0) + 1);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for(int i : map.keySet())
            pq.add(new int[]{i, map.get(i)});
        int[] ans = new int[k];
        for(int i = 0; i < k; i++)
            ans[i] = pq.remove()[0];
        return ans;
    }
}
