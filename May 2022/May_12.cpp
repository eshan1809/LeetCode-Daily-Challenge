class Solution {
public:
    void helper(unordered_map<int, int> &mp, vector<vector<int> > &ans, vector<int> &v){
        if(mp.empty()){
            vector<int> tmp;
            for(auto &i : v)
                tmp.push_back(i);
            ans.push_back(tmp);
            return;
        }
        
        unordered_map<int, int> nmp;
        for(auto &p : mp)
            nmp[p.first] = p.second;
        
        for(auto &p : mp){
            if(p.second == 1){
                nmp.erase(p.first);
                v.push_back(p.first);
                helper(nmp, ans, v);
                v.pop_back();
                nmp[p.first] = 1;
            } else{
                nmp[p.first] = p.second - 1;
                v.push_back(p.first);
                helper(nmp, ans, v);
                v.pop_back();
                nmp[p.first] = p.second;
            }
        }
    }
    
    vector<vector<int>> permuteUnique(vector<int>& nums) {
        int n = nums.size();
        vector<vector<int> > ans;
        unordered_map<int, int> mp;
        for(auto &i : nums)
            mp[i]++;
        vector<int> v;
        helper(mp, ans, v);
        return ans;
    }
};
