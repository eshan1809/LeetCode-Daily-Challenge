/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    void helper(TreeNode* root, int targetSum, int sum, vector<int> &vec, vector<vector<int>> &ans){
        if(root == nullptr)
            return;
        if(root->left == nullptr && root->right == nullptr){
            if(sum + root->val == targetSum){
                vec.push_back(root->val);
                vector<int> v;
                v.assign(vec.begin(), vec.end()); 
                ans.push_back(v);
                vec.pop_back();
            }
            return;
        }
        vec.push_back(root->val);
        helper(root->left, targetSum, sum + root->val, vec, ans);
        helper(root->right, targetSum, sum + root->val, vec, ans);
        vec.pop_back();
    }
    
    vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
        vector<vector<int>> ans;
        vector<int> vec;
        helper(root, targetSum, 0, vec, ans);
        return ans;
    }
};
