class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        
        List<int[]> list = new ArrayList<>();
        int n = envelopes.length, prev = -1;
        for(int i = 0; i < n; i++){
            int idx = search(list, envelopes[i][1]);
            if(idx == list.size()){
                if(prev != envelopes[i][0]){
                    list.add(envelopes[i]);
                    prev = envelopes[i][0];
                } else
                    list.get(list.size() - 1)[1] = Math.min(list.get(list.size() - 1)[1], envelopes[i][1]);
            } else{
                list.set(idx, envelopes[i]);
            }
        }
        
        return list.size();
    }
    
    private int search(List<int[]> list, int ins){
        int lo = 0, hi = list.size() - 1, ans = hi + 1;
        while(lo <= hi){
            int mid = (lo + hi) / 2;
            if(list.get(mid)[1] >= ins){
                ans = mid;
                hi = mid - 1;
            } else{
                lo = mid + 1;
            }
        }
        return ans;
    }
}
