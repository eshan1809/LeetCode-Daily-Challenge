class Solution {
public:
    int maxPerformance(int n, vector<int>& speed, vector<int>& efficiency, int k) {
        int mod = (int)(1e9 + 7);
        vector<pair<int, int> > vec;
        for (int i = 0; i < n; ++i)
            vec.push_back({efficiency[i], speed[i]});
        sort(vec.begin(), vec.end());
        priority_queue<int, vector<int>, greater<int> > pq;
        long speedSum = 0, ans = 0;
        for(int i = n - 1; i >= 0; i--){
            int eff = vec[i].first, sp = vec[i].second;
            if (pq.size() > k - 1){
                speedSum -= pq.top();
                pq.pop();
            }
            pq.push(sp);
            speedSum += sp;
            ans = max(ans, speedSum * eff);
        }
        return (int) (ans % mod);
    }
};
