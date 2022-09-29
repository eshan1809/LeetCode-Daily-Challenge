class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] == b[1]) ? (a[0] - b[0]) : (a[1] - b[1]));
        for(int i : arr)
            pq.add(new int[]{i, Math.abs(x - i)});
        List<Integer> list = new ArrayList<>(k);
        while(k-- > 0)
            list.add(pq.remove()[0]);
        Collections.sort(list);
        return list;
    }
}
