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
    int freq[10];
    
    void helper(TreeNode* root){
        if(root->left == nullptr && root->right == nullptr){
            freq[root->val]++;
            int o = 0;
            for(int i : freq)
                if((i & 1) == 1)
                    o++;
            if(o <= 1)
                ans++;
            freq[root->val]--;
            return;
        }
        freq[root->val]++;
        if(root->left != nullptr)
            helper(root->left);
        if(root->right != nullptr)
            helper(root->right);
        freq[root->val]--;
    }
    
    int pseudoPalindromicPaths (TreeNode* root) {
        ans = 0;
        for(int i = 0; i < 10; i++)
            freq[i] = 0;
        helper(root);
        return ans;
    }
};
