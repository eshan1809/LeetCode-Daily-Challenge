class Solution {
public:
    static bool cmp(vector<int> &a, vector<int> &b){
        return a[1] < b[1];
    }
    
    int scheduleCourse(vector<vector<int>>& courses) {
        sort(courses.begin(), courses.end(), cmp);
        priority_queue<int> pq;
        int curr = 0;
        for(auto &i : courses){
            if(curr + i[0] <= i[1]){
                curr += i[0];
                pq.push(i[0]);
            } else if(!pq.empty() && pq.top() > i[0]){
                curr -= pq.top();
                pq.pop();
                curr += i[0];
                pq.push(i[0]);
            }
        }
        return pq.size();
    }
};
