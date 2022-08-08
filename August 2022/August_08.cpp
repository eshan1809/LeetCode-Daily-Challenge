class Solution {
public:
    int find(vector<int> &vec, int &val){
        int ans = vec.size(), lo = 0, hi = ans - 1;
        while(lo <= hi){
            int mid = (lo + hi) >> 1;
            if(vec[mid] >= val){
                ans = mid;
                hi = mid - 1;
            } else
                lo = mid + 1;
        }
        return ans;
    }
    
    int lengthOfLIS(vector<int>& nums) {
        vector<int> vec;
        for(int val : nums){
            int idx = find(vec, val);
            if(idx == vec.size())
                vec.push_back(val);
            else
                vec[idx] = val;
        }
        return vec.size();
    }
};
