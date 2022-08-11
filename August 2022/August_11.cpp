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
    bool isBST;
    
    pair<int, int> helper(TreeNode* root){
        pair<int, int> p;
        if(root->left == nullptr)
            p.first = root->val;
        else{
            pair<int, int> left = helper(root->left);
            if(left.second >= root->val)
                isBST = false;
            p.first = left.first;
        }
        if(root->right == nullptr)
            p.second = root->val;
        else{
            pair<int, int> right = helper(root->right);
            if(right.first <= root->val)
                isBST = false;
            p.second = right.second;
        }
        return p;
    }
    
    bool isValidBST(TreeNode* root) {
        isBST = true;
        helper(root);
        return isBST;
    }
};
