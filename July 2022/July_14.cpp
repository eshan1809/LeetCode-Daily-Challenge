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
    map<int, int> mp;
    int n, id;
    
    TreeNode* buildTree(vector<int>& pre, vector<int>& in, int l, int r){
        if(l > r)
            return nullptr;
        int m = mp[pre[id]];
        TreeNode* root = new TreeNode(pre[id++]);
        root->left = buildTree(pre, in, l, m - 1);
        root->right = buildTree(pre, in, m + 1, r);
        return root;
    }
    
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        n = inorder.size();
        id = 0;
        for(int i = 0; i < n; i++)
            mp[inorder[i]] = i;
        return buildTree(preorder, inorder, 0, n - 1);
    }
};
