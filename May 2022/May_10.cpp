class Solution {
public:
    vector<vector<int>> ans;
    vector<int> vec;
    
    void helper(int num, int k, int sum){
        if(num == 10){
            if(k == 0 && sum == 0){
                vector<int> v;
                v.assign(vec.begin(), vec.end());
                ans.push_back(v);
            }
            return;
        }
        
        if(num <= sum && k > 0){
            vec.push_back(num);
            helper(num + 1, k - 1, sum - num);
            vec.pop_back();
        }
        
        helper(num + 1, k, sum);
    }
    
    vector<vector<int>> combinationSum3(int k, int n) {
        helper(1, k, n);
        return ans;
    }
};
