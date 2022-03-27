class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int n = mat.length, m = mat[0].length;
        List<int[]> list = new ArrayList<>(n);
        for(int i = 0; i < n; i++){
            int lo = 0, hi = m - 1, ans = -1;
            while(lo <= hi){
                int mid = (lo + hi) / 2;
                if(mat[i][mid] == 1){
                    ans = mid;
                    lo = mid + 1;
                } else 
                    hi = mid - 1;
            }
            list.add(new int[]{i, ans + 1});
        }
        Collections.sort(list, (a, b) -> (a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]));
        int[] ans = new int[k];
        for(int i = 0; i < k; i++)
            ans[i] = list.get(i)[0];
        return ans;
    }
}
