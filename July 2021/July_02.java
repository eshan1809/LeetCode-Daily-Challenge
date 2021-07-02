class Solution {
    int X;
    class Pair implements Comparable<Pair> {
        int val;
        Pair(int val) {
            this.val = val;
        }
        public int compareTo(Pair o) {
            int a = Math.abs(this.val - X), b = Math.abs(o.val - X);
            if (a == b)
                return this.val - o.val;
            return a - b;
        }
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        X = x;
        for (int i : arr)
            pq.add(new Pair(i));
        while (k-- > 0)
            list.add(pq.remove().val);
        Collections.sort(list);
        return list;
    }
}
