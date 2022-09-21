class Solution {
public:
    vector<int> sumEvenAfterQueries(vector<int>& nums, vector<vector<int>>& queries) {
        vector<int> ans(queries.size(), 0);
        int sum = 0;
        for(int j = 0; j < nums.size(); j++){
            if((nums[j] & 1) == 0){
                sum += nums[j];
            }
        }
        for(int i = 0; i < queries.size(); i++){
            if((nums[queries[i][1]] & 1) == 0)
                sum -= nums[queries[i][1]];
            nums[queries[i][1]] += queries[i][0];
            if((nums[queries[i][1]] & 1) == 0)
                sum += nums[queries[i][1]];
            ans[i] = sum;
        }
        return ans;
    }
};
