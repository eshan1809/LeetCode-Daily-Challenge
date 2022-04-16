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
    int helper(TreeNode* root, int val){
        if(root == nullptr)
            return 0;
        int r = helper(root->right, val);
        root->val += r + val;
        int l = helper(root->left, root->val);
        return l + root->val - val;
    }
    
    TreeNode* convertBST(TreeNode* root) {
        helper(root, 0);
        return root;
    }
};
