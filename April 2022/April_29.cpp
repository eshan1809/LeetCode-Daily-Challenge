class Solution {
public:
    bool isBipartite(vector<vector<int>>& graph) {
        int n = graph.size();
        vector<int> grp(n, -1);
        for(int i = 0; i < n; i++){
            if(grp[i] == -1){
                queue<int> q;
                q.push(i);
                int g = 0;
                while(!q.empty()){
                    int size = q.size();
                    while(size--){
                        int rem = q.front(); q.pop();
                        if(grp[rem] != -1){
                            if(grp[rem] == g)
                                continue;
                            return false;
                        }
                        grp[rem] = g;
                        for(auto &nbr : graph[rem])
                            q.push(nbr);
                    }
                    g = 1 - g;
                }
            }
        }
        return true;
    }
};
