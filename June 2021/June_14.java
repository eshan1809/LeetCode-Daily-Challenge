class Solution {
    public class Pair implements Comparable<Pair>{
        int nob, nou;
        Pair(int a, int b){
            nob = a;
            nou = b;
        }
        public int compareTo(Pair o){
            if(o.nou != this.nou) return o.nou - this.nou;
            return this.nob - o.nob;
        }
    }
    
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int[] box : boxTypes) pq.add(new Pair(box[0], box[1]));
        int size = 0, ans = 0;
        while(pq.size() > 0){
            Pair p = pq.remove();
            if(p.nob + size > truckSize){
                ans += p.nou * (truckSize - size);
                break;
            } else{
                size += p.nob;
                ans += p.nob * p.nou;
            }
        }
        return ans;
    }
}
