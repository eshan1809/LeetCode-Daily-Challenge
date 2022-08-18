class Solution {
public:
    int minSetSize(vector<int>& arr) {
        unordered_map<int, int> mp;
        for(int i : arr)
            mp[i]++;
        priority_queue<pair<int, int> > pq;
        for(auto p : mp)
            pq.push({p.second, p.first});
        int rem = 0, ans = 0;
        while(rem < arr.size() / 2){
            pair p = pq.top();
            pq.pop();
            rem += p.first;
            ans++;
        }
        return ans;
    }
};
