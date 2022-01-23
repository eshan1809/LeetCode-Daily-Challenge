class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> all = new ArrayList<>(), ans = new ArrayList<>();
        for(int i = 1; i <= 9; i++){
            find(all, i, i + 1);
        }
        for(int x : all){
            if(low <= x && x <= high)
                ans.add(x);
        }
        Collections.sort(ans);
        return ans;
    }
    
    private void find(List<Integer> all, int nsf, int i){
        if(i == 10){
            all.add(nsf);
            return;
        }
        all.add(nsf);
        find(all, nsf * 10 + i, i + 1);
    }
}
