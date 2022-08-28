class Solution {
public:
    vector<vector<int>> diagonalSort(vector<vector<int>>& mat) {
        int n = mat.size(), m = mat[0].size();
        for(int r = n - 1; r > 0; r--){
            vector<int> vec;
            int i = r, j = 0;
            while(i < n && j < m){
                vec.push_back(mat[i][j]);
                i++;
                j++;
            }
            sort(vec.begin(), vec.end());
            i = r;
            j = 0;
            while(i < n && j < m){
                mat[i][j] = vec[j];
                i++;
                j++;
            }
        }
        for(int c = 0; c < m; c++){
            vector<int> vec;
            int i = 0, j = c;
            while(i < n && j < m){
                vec.push_back(mat[i][j]);
                i++;
                j++;
            }
            sort(vec.begin(), vec.end());
            i = 0;
            j = c;
            while(i < n && j < m){
                mat[i][j] = vec[i];
                i++;
                j++;
            }
        }
        return mat;
    }
};
