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
    void helper(vector<int> &vec, TreeNode* root){
        if(root == nullptr)
            return;
        helper(vec, root->left);
        vec.push_back(root->val);
        helper(vec, root->right);
    }
    
    vector<int> inorderTraversal(TreeNode* root) {
        vector<int> vec;
        helper(vec, root);
        return vec;
    }
};
