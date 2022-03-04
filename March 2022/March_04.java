class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] arr = new double[query_row + 1][query_glass + 1];
        arr[0][0] = 1.0 * poured;
        for(int i = 0; i < query_row; i++){
            for(int j = 0; j <= i && j <= query_glass; j++){
                if(arr[i][j] > 1){
                    double rem = arr[i][j] - 1;
                    arr[i + 1][j] += rem / 2;
                    if(j + 1 <= query_glass)
                        arr[i + 1][j + 1] += rem / 2;
                    arr[i][j] = 1.0;
                }
            }
        }
        return Math.min(arr[query_row][query_glass], 1);
    }
}
