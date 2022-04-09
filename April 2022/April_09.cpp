class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        unordered_map<int, int> hm;
        for(int i : nums)
            hm[i]++;
        
        priority_queue<pair<int, int> > pq;
        for(auto &i : hm)
            pq.push(make_pair(i.second, i.first));
        
        vector<int> ans(k);
        for(int i = 0; i < k; i++){
            ans[i] = pq.top().second;
            pq.pop();
        }
        return ans;
    }
};
