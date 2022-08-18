class Solution {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : arr)
            map.put(i, map.getOrDefault(i, 0) + 1);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for(int i : map.keySet())
            pq.add(new int[]{map.get(i), i});
        int rem = 0, ans = 0;
        while(rem < arr.length / 2){
            rem += pq.remove()[0];
            ans++;
        }
        return ans;
    }
}
