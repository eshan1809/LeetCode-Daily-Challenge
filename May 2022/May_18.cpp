class Solution {
public:
    
    vector<vector<int>> ans;
    int time;
    
    void helper(vector<vector<int>> &graph, vector<int> &par, vector<int> &dis, vector<int> &mini, vector<bool> &vis, int node){
        dis[node] = mini[node] = time++;
        vis[node] = true;
        
        for(auto &nbr : graph[node]){
            if(par[node] == nbr)
                continue;
            if(vis[nbr])
                mini[node] = min(mini[node], dis[nbr]);
            else{
                par[nbr] = node;
                helper(graph, par, dis, mini, vis, nbr);
                mini[node] = min(mini[node], mini[nbr]);
                if(mini[nbr] > dis[node]){
                    vector<int> v(2);
                    v[0] = node;
                    v[1] = nbr;
                    ans.push_back(v);
                }
            }
        }
    }
    
    vector<vector<int>> criticalConnections(int n, vector<vector<int>>& connections) {
        vector<vector<int>> graph(n, vector<int>());
        for(auto &a : connections){
            graph[a[0]].push_back(a[1]);
            graph[a[1]].push_back(a[0]);
        }
        
        vector<int> par(n), dis(n), mini(n);
        vector<bool> vis(n, false);
        time = 0;
        helper(graph, par, dis, mini, vis, 0);
        return ans;
    }
};
