class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n = grid.length, m = grid[0].length;
        k %= (n * m);
        Integer[][] arr = new Integer[n][m];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                arr[(i + (j + k) / m) % n][(k + j) % m] = grid[i][j];
        List<List<Integer>> list = new ArrayList<>(n);
        for(int i = 0; i < n; i++)
            list.add(Arrays.asList(arr[i]));
        return list;
    }
}
