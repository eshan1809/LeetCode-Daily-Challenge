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
    int deepestLeavesSum(TreeNode* root) {
        queue<TreeNode*> q;
        q.push(root);
        int ans = 0;
        while(!q.empty()){
            int sum = 0, size = q.size();
            while(size--){
                TreeNode* rem = q.front(); q.pop();
                sum += rem->val;
                if(rem->left != nullptr)
                    q.push(rem->left);
                if(rem->right != nullptr)
                    q.push(rem->right);
            }
            ans = sum;
        }
        return ans;
    }
};
