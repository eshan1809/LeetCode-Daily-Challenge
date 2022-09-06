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
    bool helper(TreeNode* root){
        if(root == nullptr)
            return false;
        bool l = helper(root->left), r = helper(root->right);
        if(l == false)
            root->left = nullptr;
        if(r == false)
            root->right = nullptr;
        return (l || r || (root->val == 1));
    }
    
    TreeNode* pruneTree(TreeNode* root) {
        return helper(root) ? root : nullptr;
    }
};
