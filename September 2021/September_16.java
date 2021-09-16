class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length, rb = 0, cb = 0, re = n - 1, ce = m - 1;
        List<Integer> list = new ArrayList<>();
        while(rb <= re && cb <= ce){
            for(int j = cb; j <= ce; j++)
                list.add(matrix[rb][j]);
            rb++;
            for(int i = rb; i <= re; i++)
                list.add(matrix[i][ce]);
            ce--;
            if(rb <= re){
                for(int j = ce; j >= cb; j--)
                    list.add(matrix[re][j]);
                re--;
            }
            if(cb <= ce){
                for(int i = re; i >= rb; i--)
                    list.add(matrix[i][cb]);
                cb++;
            }
        }
        return list;
    }
}
