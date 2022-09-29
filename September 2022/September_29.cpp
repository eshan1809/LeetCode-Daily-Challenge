class Solution {
public:
    static bool cmp(pair<int, int> &a, pair<int, int> &b){
        if(a.second == b.second)
            return a.first < b.first;
        return a.second < b.second;
    }
    
    vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        vector<pair<int, int> > vec;
        for(int i : arr)
            vec.push_back({i, abs(x - i)});
        sort(vec.begin(), vec.end(), cmp);
        vector<int> ans(k);
        while(k-- > 0)
            ans[k] = vec[k].first;
        sort(ans.begin(), ans.end());
        return ans;
    }
};
