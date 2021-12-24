class Solution {
    public class Pair{
        int start, end;
        Pair(int start, int end){
            this.start = start;
            this.end = end;
        }
    } 
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(intervals[0][0], intervals[0][1]));
        for(int i = 1; i < intervals.length; i++){
            Pair p = st.pop();
            if(p.end >= intervals[i][0]){
                p.end = Math.max(intervals[i][1], p.end);
                st.push(p);
            } else{
                st.push(p);
                st.push(new Pair(intervals[i][0], intervals[i][1]));
            }
        }
        int[][] res = new int[st.size()][2];
        for(int i = res.length - 1; i >= 0; i--){
            Pair p = st.pop();
            res[i][0] = p.start;
            res[i][1] = p.end;
        }
        return res;
    }
}
