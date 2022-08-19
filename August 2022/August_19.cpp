class Solution {
public:
    bool isPossible(vector<int>& nums) {
        priority_queue<int, vector<int>, greater<int> > pq;
        int i = 0, n = nums.size();
        while(i < n && nums[i] == nums[0]){
            pq.push(1);
            i++;
        }
        while(i < n){
            int j = i;
            vector<int> vec;
            while(j < n && nums[j] == nums[i - 1] + 1){
                if(!pq.empty()){
                    int rem = pq.top();
                    pq.pop();
                    vec.push_back(rem + 1);
                } else
                    vec.push_back(1);
                j++;
            }
            if(i == j)
                vec.push_back(1);
            i = max(j, i + 1);
            if(!pq.empty() && pq.top() < 3)
                return false;
            while(!pq.empty())
                pq.pop();
            for(int &v : vec)
                pq.push(v);
        }
        if(!pq.empty() && pq.top() < 3)
            return false;
        return true;
    }
};
