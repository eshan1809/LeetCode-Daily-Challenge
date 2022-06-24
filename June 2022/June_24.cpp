class Solution {
public:
    bool isPossible(vector<int>& target) {
        priority_queue<int> pq;
        long sum = 0;
        for(int i : target){
            pq.push(i);
            sum += i;
        }
        while(!pq.empty()){
            int rem = pq.top();
            pq.pop();
            sum -= rem;
            if(rem == 1 || sum == 1)
                return true;
            if(rem < sum || sum == 0 || rem % sum == 0)
                return false;
            rem %= sum;
            pq.push(rem);
            sum += rem;
        }
        return true;
    }
};
