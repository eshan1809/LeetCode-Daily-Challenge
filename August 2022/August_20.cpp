class Solution {
public:
    int minRefuelStops(int target, int startFuel, vector<vector<int>>& stations) {
        int i = 0, n = stations.size(), d = startFuel, ans = 0;
        priority_queue<int> pq;
        while(d < target && i < n){
            while(i < n && stations[i][0] <= d)
                pq.push(stations[i++][1]);
            bool flag = false;
            while(!pq.empty() && i < n && d < stations[i][0] && d < target){
                d += pq.top();
                pq.pop();
                ans++;
                flag = true;
            }
            if(!flag)
                break;
        }
        while(!pq.empty() && d < target){
            d += pq.top();
            pq.pop();
            ans++;
        }
        return d < target ? -1 : ans;
    }
};
