class Solution {
public:
    vector<double> calcEquation(vector<vector<string>>& equations, vector<double>& values, vector<vector<string>>& queries) {
        unordered_map<string, vector<pair<string, double> > > mp;
        for(int i = 0; i < equations.size(); i++){
            mp[equations[i][0]].push_back({equations[i][1], values[i]});
            mp[equations[i][1]].push_back({equations[i][0], 1 / values[i]});
        }
        
        int n = queries.size();
        vector<double> ans(n, -1.0);
        for(int i = 0; i < n; i++){
            if(mp.find(queries[i][0]) != mp.end() && mp.find(queries[i][1]) != mp.end()){
                vector<pair<string, double>> l1, l2;
                unordered_set<string> vis;
                find(queries[i][0], 1.0, mp, l1, vis);
                find(queries[i][1], 1.0, mp, l2, vis);
                bool flag = false;
                for(auto &p1 : l1){
                    for(auto &p2 : l2){
                        if(p1.first == p2.first){
                            ans[i] = p1.second / p2.second;
                            flag = true;
                            break;
                        }
                    }
                    if(flag)
                        break;
                }
            }
        }
        return ans;
    }
    
    void find(string &s, double d, unordered_map<string, vector<pair<string, double> > > &mp, vector<pair<string, double> > & vec, unordered_set<string> vis){
        vis.insert(s);
        for(auto &p : mp[s])
            if(vis.find(p.first) == vis.end())
                find(p.first, d * p.second, mp, vec, vis);
        vis.erase(s);
        vec.push_back({s, d});
    }
};
