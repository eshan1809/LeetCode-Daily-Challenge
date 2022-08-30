class Solution {
public:
    void rotate(vector<vector<int>>& matrix) {
        int n = matrix.size();
        for(int i = 0; i < n / 2; i++){
            int e = n - i - 1;
            for(int j = i, k = 0; j < e; j++, k++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[e - k][i];
                matrix[e - k][i] = matrix[e][e - k];
                matrix[e][e - k] = matrix[j][e];
                matrix[j][e] = tmp;
            }
        }
    }
};
