class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int mod = (int)(1e9 + 7);
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; ++i)
            list.add(new int[]{efficiency[i], speed[i]});
        Collections.sort(list, ((a, b) -> b[0] - a[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
        long speedSum = 0, ans = 0;
        for (var p : list) {
            int eff = p[0], sp = p[1];
            if (pq.size() > k - 1)
                speedSum -= pq.remove();
            pq.add(sp);
            speedSum += sp;
            ans = Math.max(ans, speedSum * eff);
        }
        return (int) (ans % mod);
    }
}
