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
    int ans;
    
    int helper(TreeNode* root){
        int left = (root->left == nullptr ? 1 : helper(root->left));
        int right = (root->right == nullptr ? 1 : helper(root->right));
        if(left == 2 || right == 2){
            ans++;
            return 0;
        }
        if(left == 0 || right == 0)
            return 1;
        return 2;
    }
    
    int minCameraCover(TreeNode* root) {
        ans = 0;
        if(helper(root) == 2)
            ans++;
        return ans;
    }
};
