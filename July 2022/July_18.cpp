class Solution {
public:
    int numSubmatrixSumTarget(vector<vector<int>>& matrix, int target) {
        int n = matrix.size(), m = matrix[0].size(), count = 0;
        for(int i = 0; i < n; i++)
            for(int j = 1; j < m; j++)
                matrix[i][j] += matrix[i][j - 1];
        for(int b = 0; b < m; b++){
            for(int e = b; e < m; e++){
                int sum = 0;
                unordered_map<int, int> mp;
                mp[0] = 1;
                for(int i = 0; i < n; i++){
                    sum += matrix[i][e] - (b == 0 ? 0 : matrix[i][b - 1]);
                    count += mp[sum - target];
                    mp[sum]++;
                }
            }
        }
        return count;
    }
};
