class Solution {
public:
    int furthestBuilding(vector<int>& heights, int bricks, int ladders) {
        int i = 0, n = heights.size();
        priority_queue<int, vector<int>, greater<int> > pq;
        while(++i < n && pq.size() < ladders){
            int diff = heights[i] - heights[i - 1];
            if(diff > 0)
                pq.push(diff);
        }
        i--;
        while(++i < n){
            int diff = heights[i] - heights[i - 1];
            if(diff <= 0)
                continue;
            if(!pq.empty() && pq.top() < diff && bricks >= pq.top()){
                bricks -= pq.top();
                pq.pop();
                pq.push(diff);
            } else if(bricks >= diff)
                bricks -= diff;
            else
                return i - 1;
        }
        return n - 1;
    }
};
