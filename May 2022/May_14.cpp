class Solution {
public:
    int networkDelayTime(vector<vector<int>>& times, int n, int k) {
        vector<vector<pair<int, int> > > graph(n);
        for(auto &e : times)
            graph[e[0] - 1].push_back({e[1] - 1, e[2]});
        
        int time[n];
        memset(time, -1, sizeof(time));
        
        priority_queue<pair<int, int>, vector<pair<int, int> >, greater<pair<int, int> > > pq;
        pq.push({0, k - 1});
        
        while(!pq.empty()){
            pair<int, int> rem = pq.top(); pq.pop();
            if(time[rem.second] != -1)
                continue;
            time[rem.second] = rem.first;
            for(auto &nbr : graph[rem.second])
                pq.push({nbr.second + rem.first, nbr.first});
        }
        
        int ans = 0;
        for(auto &i : time){
            if(i == -1)
                return -1;
            ans = max(ans, i);
        }
        return ans;
    }
};
