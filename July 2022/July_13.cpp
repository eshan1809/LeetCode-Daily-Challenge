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
    vector<vector<int>> levelOrder(TreeNode* root) {
        vector<vector<int>> vec;
        if(root == nullptr)
            return vec;
        queue<TreeNode*> q;
        q.push(root);
        while(!q.empty()){
            int size = q.size();
            vector<int> v;
            while(size-- > 0){
                TreeNode* rem = q.front();
                q.pop();
                v.push_back(rem->val);
                if(rem->left != nullptr)
                    q.push(rem->left);
                if(rem->right != nullptr)
                    q.push(rem->right);
            }
            vec.push_back(v);
        }
        return vec;
    }
};
