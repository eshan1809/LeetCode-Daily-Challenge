class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        for(int r = n - 1; r > 0; r--){
            List<Integer> list = new ArrayList<>();
            int i = r, j = 0;
            while(i < n && j < m)
                list.add(mat[i++][j++]);
            Collections.sort(list);
            i = r;
            j = 0;
            while(i < n && j < m)
                mat[i++][j] = list.get(j++);
        }
        for(int c = 0; c < m; c++){
            List<Integer> list = new ArrayList<>();
            int i = 0, j = c;
            while(i < n && j < m)
                list.add(mat[i++][j++]);
            Collections.sort(list);
            i = 0;
            j = c;
            while(i < n && j < m)
                mat[i][j++] = list.get(i++);
        }
        return mat;
    }
}
