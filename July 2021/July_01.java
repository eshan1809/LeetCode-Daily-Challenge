class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>();
        if (n == 0) {
            ans.add(0);
            return ans;
        }
        backtrack(ans, n);
        return ans;
    }

    int temp;

    private void backtrack(List<Integer> ans, int n) {
        if (n == 0) {
            ans.add(temp);
            return;
        }
        backtrack(ans, n - 1);
        temp = temp ^ (1 << (n - 1));
        backtrack(ans, n - 1);
    }
}
