/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    void helper(TreeNode* root, TreeNode* p, vector<TreeNode*> &v){
        if(root == nullptr)
            return;
        if(root == p){
            v.push_back(p);
            return;
        }
        helper(root->left, p, v);
        if(v.size() > 0){
            v.push_back(root);
            return;
        }
        helper(root->right, p, v);
        if(v.size() > 0){
            v.push_back(root);
            return;
        }
        return;
    }
    
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        vector<TreeNode*> v1, v2;
        helper(root, p, v1);
        helper(root, q, v2);
        int i1 = v1.size() - 1, i2 = v2.size() - 1;
        while(i1 >= 0 && i2 >= 0 && v1[i1] == v2[i2])
            i1--, i2--;
        return v1[i1 + 1];
    }
};
