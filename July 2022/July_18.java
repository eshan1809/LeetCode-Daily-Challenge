class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length, count = 0;
        for(int i = 0; i < n; i++)
            for(int j = 1; j < m; j++)
                matrix[i][j] += matrix[i][j - 1];
        for(int b = 0; b < m; b++){
            for(int e = b; e < m; e++){
                int sum = 0;
                Map<Integer, Integer> map = new HashMap<>();
                map.put(0, 1);
                for(int i = 0; i < n; i++){
                    sum += matrix[i][e] - (b == 0 ? 0 : matrix[i][b - 1]);
                    count += map.getOrDefault(sum - target, 0);
                    map.put(sum, map.getOrDefault(sum, 0) + 1);
                }
            }
        }
        return count;
    }
}
