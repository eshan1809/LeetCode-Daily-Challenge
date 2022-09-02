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
    vector<double> averageOfLevels(TreeNode* root) {
        vector<double> vec;
        queue<TreeNode*> q;
        q.push(root);
        while(!q.empty()){
            long sum = 0ll;
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode* node = q.front();
                q.pop();
                sum += node->val;
                if(node->left != nullptr)
                    q.push(node->left);
                if(node->right != nullptr)
                    q.push(node->right);
            }
            vec.push_back(1.0 * sum / size);
        }
        return vec;
    }
};
