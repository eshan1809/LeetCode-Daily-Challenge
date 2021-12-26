class Solution {
    class Pair implements Comparable<Pair>{
        double dist;
        int id;
        Pair(double dist, int id){
            this.dist = dist;
            this.id = id;
        }
        public int compareTo(Pair o){
            if(this.dist - o.dist > 0)
                return 1;
            return -1;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int i = 0; i < n; i++){
            double dist = Math.sqrt(points[i][0] * points[i][0] + points[i][1] * points[i][1]);
            pq.add(new Pair(dist, i));
        }
        int[][] ans = new int[k][2];
        for(int i = 0; i < k; i++)
            ans[i] = points[pq.remove().id];
        return ans;
    }
}
