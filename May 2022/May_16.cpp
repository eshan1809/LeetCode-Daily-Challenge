class Solution {
public:
    int shortestPathBinaryMatrix(vector<vector<int>>& grid) {
        int n = grid.size(), len = 1;
        queue<pair<int, int> > q;
        q.push({0, 0});
        while(!q.empty()){
            int size = q.size();
            while(size--){
                pair<int, int> rem = q.front(); q.pop();
                if(rem.first == n - 1 && rem.second == n - 1)
                    return len;
                if(grid[rem.first][rem.second] == 1)
                    continue;
                grid[rem.first][rem.second] = 1;
                for(int i = -1; i <= 1; i++){
                    for(int j = -1; j <= 1; j++){
                        if(i == 0 && j == 0)
                            continue;
                        int x = rem.first + i, y = rem.second + j;
                        if(x >= 0 && x < n && y >= 0 && y < n && grid[x][y] == 0)
                            q.push({x, y});
                    }
                }
            }
            len++;
        }
        return -1;
    }
};
