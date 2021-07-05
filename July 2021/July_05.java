class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if(r * c != nums.length * nums[0].length) return nums;
        int[] values = new int[nums.length * nums[0].length];
        int k = 0;
        for(int i = 0; i < nums.length; i++)
            for(int j = 0; j < nums[0].length; j++)
                values[k++] = nums[i][j];
        int[][] matrix = new int[r][c];
        k = 0;
        for(int i = 0; i < r; i++)
            for(int j = 0; j < c; j++)
                matrix[i][j] = values[k++];
        return matrix;
    }
}
