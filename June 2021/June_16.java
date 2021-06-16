class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList();
        solve(0, 0, n, "", list);
        return list;
    }
    public void solve(int open, int close, int n, String psf, List<String> list){
        if(open == n && close == n){
            list.add(psf);
            return;
        }
        if(open < n) solve(open + 1, close, n, psf + "(", list);
        if(close < open && close < n) solve(open, close + 1, n, psf + ")", list);
    }
}
