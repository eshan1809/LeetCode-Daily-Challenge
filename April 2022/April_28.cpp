#define ppii pair<pair<int, int>, int>
class Solution {
public:
    struct cmp {
        constexpr bool operator()(ppii const& a, ppii const& b)
            const noexcept
        {
            return a.second > b.second;
        }
    };
    
    int minimumEffortPath(vector<vector<int>>& heights) {
        int n = heights.size(), m = heights[0].size();
        bool vis[n][m];
        memset(vis, false, sizeof(vis));
        
        priority_queue<ppii, vector<ppii>, cmp> pq;
        pq.push({{0, 0}, 0});
        
        while(!pq.empty()){
            ppii rem = pq.top(); pq.pop();
            int i = rem.first.first, j = rem.first.second;
            if(vis[i][j])
                continue;
            vis[i][j] = true;
            if(i == n - 1 && j == m - 1)
                return rem.second;
            if(i > 0)
                pq.push({{i - 1, j}, max(rem.second, abs(heights[i - 1][j] - heights[i][j]))});
            if(j > 0)
                pq.push({{i, j - 1}, max(rem.second, abs(heights[i][j - 1] - heights[i][j]))});
            if(i + 1 < n)
                pq.push({{i + 1, j}, max(rem.second, abs(heights[i + 1][j] - heights[i][j]))});
            if(j + 1 < m)
                pq.push({{i, j + 1}, max(rem.second, abs(heights[i][j + 1] - heights[i][j]))});
        }
        
        return 0;
    }
};
