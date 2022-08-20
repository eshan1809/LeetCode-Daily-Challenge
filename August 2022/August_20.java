class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int i = 0, n = stations.length, d = startFuel, ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        while(d < target && i < n){
            while(i < n && stations[i][0] <= d)
                pq.add(stations[i++][1]);
            boolean flag = false;
            while(!pq.isEmpty() && i < n && d < stations[i][0] && d < target){
                d += pq.remove();
                ans++;
                flag = true;
            }
            if(!flag)
                break;
        }
        while(!pq.isEmpty() && d < target){
            d += pq.remove();
            ans++;
        }
        return d < target ? -1 : ans;
    }
}
