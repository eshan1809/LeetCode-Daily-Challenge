class Solution {
public:
    int n = (int)2e4 + 10;
    int tree[(int)2e4 + 11];
    
    void update(int idx, int val) {
        while (idx <= n) {
            tree[idx] += val;
            idx += idx & -idx;
        }
    }
    
    int query(int l, int r) {
        return getSum(r) - getSum(l - 1);
    }

    int getSum(int idx) {
        int ans = 0;
        while (idx > 0) {
            ans += tree[idx];
            idx -= idx & -idx;
        }
        return ans;
    }
    
    vector<int> countSmaller(vector<int>& nums) {
        vector<int> ans(nums.size());
        memset(tree, sizeof(tree),0);
        int add = (int)1e4 + 5;
        for(int i = nums.size() - 1; i >= 0; i--){
            int curr = nums[i] + add;
            ans[i] = max(query(1, curr - 1), 0);
            update(curr, 1);
        }
        return ans;
    }
};
