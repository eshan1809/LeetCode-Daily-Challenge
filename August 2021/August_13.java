class Solution {
    public void setZeroes(int[][] matrix) {
        Set<Integer> sr = new HashSet<>(), sc = new HashSet<>();
        for(int i = 0; i < matrix.length; i++)
            for(int j = 0; j < matrix[0].length; j++)
                if(matrix[i][j] == 0){
                    sr.add(i);
                    sc.add(j);
                }
        for(int i: sr)
            Arrays.fill(matrix[i], 0);
        for(int j: sc)
            for(int i = 0; i < matrix.length; i++)
                matrix[i][j] = 0;
    }
}
