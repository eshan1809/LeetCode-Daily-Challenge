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
    TreeNode *first, *second, *prev;
    
    void helper(TreeNode* root){
        if(root == nullptr)
            return;
        helper(root->left);
        if(prev != nullptr && prev->val > root->val){
            if(first == nullptr)
                first = prev;
            second = root;
        }
        prev = root;
        helper(root->right);
    }
    
    void recoverTree(TreeNode* root) {
        first = second = prev = nullptr;
        helper(root);
        int tmp = first->val;
        first->val = second->val;
        second->val = tmp;
    }
};
