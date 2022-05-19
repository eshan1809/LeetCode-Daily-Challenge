class Solution {
public:
    int longestIncreasingPath(vector<vector<int>>& matrix) {
        int n = matrix.size(), m = matrix[0].size();
        queue<pair<int, int> > q;
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                q.push({i, j});
        
        int dirs[4][2] = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        int dp[n][m];
        memset(dp, 0, sizeof(dp));
        int t = 1;
        while(!q.empty()){
            int size = q.size();
            while(size--){
                int i = q.front().first, j = q.front().second;
                q.pop();
                if(dp[i][j] >= t)
                    continue;
                dp[i][j] = t;
                for(auto &d : dirs){
                    int x = i + d[0], y = j + d[1];
                    if(x >= 0 && y >= 0 && x < n && y < m && matrix[x][y] > matrix[i][j])
                        q.push({x, y});
                }
            }
            t++;
        }
        return t - 1;
    }
};
