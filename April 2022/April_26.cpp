class Solution {
public:
    int minCostConnectPoints(vector<vector<int>>& points) {
        int n = points.size();
        vector<vector<pair<int, int> > > graph(n, vector<pair<int, int> >());
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                int dist = abs(points[i][0] - points[j][0]) + abs(points[i][1] - points[j][1]);
                graph[i].push_back(make_pair(dist, j));
                graph[j].push_back(make_pair(dist, i));
            }
        }
        
        bool vis[n];
        memset(vis, false, sizeof(vis));
        int cost = 0;
        
        priority_queue<pair<int, int>, vector<pair<int, int> >, greater<pair<int, int> > > pq;
        pq.push(make_pair(0, 0));
        while(!pq.empty()){
            pair rem = pq.top(); pq.pop();
            if(vis[rem.second])
                continue;
            vis[rem.second] = true;
            cost += rem.first;
            for(auto &nbr : graph[rem.second])
                if(!vis[nbr.second])
                    pq.push(nbr);
        }
        return cost;
    }
};
