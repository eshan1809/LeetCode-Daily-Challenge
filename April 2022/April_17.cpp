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
    TreeNode* curr = nullptr;
    TreeNode* ans = nullptr;
    
    void inOrder(TreeNode* root){
        if(root == nullptr)
            return;
        inOrder(root->left);
        root->left = nullptr;
        if(curr != nullptr)
            curr->right = root;
        else
            ans = root;
        curr = root;
        inOrder(root->right);
    }
    
    TreeNode* increasingBST(TreeNode* root) {
        inOrder(root);
        return ans;
    }
};
