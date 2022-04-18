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
    int ans, i;
    
    void helper(TreeNode* root, int k){
        if(root == nullptr)
            return;
        helper(root->left, k);
        if(++i == k){
            ans = root->val;
            return;
        }
        helper(root->right, k);
    }
    
    int kthSmallest(TreeNode* root, int k) {
        i = 0;
        helper(root, k);
        return ans;
    }
};
