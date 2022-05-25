class Solution {
public:
    static bool cmp(vector<int> &v1, vector<int> &v2){
        if(v1[0] == v2[0])
            return v2[1] < v1[1];
        return v1[0] < v2[0];
    }
    
    int search(vector<pair<int, int> > &vec, int v){
        int lo = 0, hi = vec.size() - 1, ans = hi + 1;
        while(lo <= hi){
            int mid = (lo + hi) / 2;
            if(vec[mid].second >= v){
                ans = mid;
                hi = mid - 1;
            } else
                lo = mid + 1;
        }
        return ans;
    }
    
    int maxEnvelopes(vector<vector<int>>& envelopes) {
        sort(envelopes.begin(), envelopes.end(), cmp);
        
        int n = envelopes.size(), prev = -1;
        vector<pair<int, int> > vec;
        for(int i = 0; i < n; i++){
            int idx = search(vec, envelopes[i][1]);
            if(idx == vec.size()){
                if(prev != envelopes[i][0]){
                    prev = envelopes[i][0];
                    vec.push_back({envelopes[i][0], envelopes[i][1]});
                } else
                    vec[vec.size() - 1].second = min(vec[vec.size() - 1].second, envelopes[i][1]);
            } else
                vec[idx] = {envelopes[i][0], envelopes[i][1]};
        }
        return vec.size();
    }
};
