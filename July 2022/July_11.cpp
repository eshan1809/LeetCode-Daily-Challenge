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
    vector<int> rightSideView(TreeNode* root) {
        vector<int> vec;
        if(root == nullptr)
            return vec;
        queue<TreeNode*> q;
        q.push(root);
        while(!q.empty()){
            int size = q.size(), last = 0;
            while(size--){
                TreeNode* rem = q.front();
                q.pop();
                if(rem->left != nullptr)
                    q.push(rem->left);
                if(rem->right != nullptr)
                    q.push(rem->right);
                last = rem->val;
            }
            vec.push_back(last);
        }
        return vec;
    }
};
