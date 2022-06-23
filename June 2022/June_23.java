class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int curr = 0;
        for(var v : courses){
            if(curr + v[0] <= v[1]){
                curr += v[0];
                pq.add(v[0]);
            } else if(!pq.isEmpty() && pq.peek() > v[0]){
                curr -= pq.remove();
                curr += v[0];
                pq.add(v[0]);
            }
        }
        return pq.size();
    }
}
