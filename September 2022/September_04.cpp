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
    vector<vector<int>> verticalTraversal(TreeNode* root) {
        map<int, vector<int> > mp;
        queue<pair<TreeNode*, int> > q;
        q.push({root, 0});
        while(!q.empty()){
            int size = q.size();
            unordered_map<int, vector<int> > tmp;
            while(size-- > 0){
                pair<TreeNode*, int> rem = q.front();
                q.pop();
                if(tmp.find(rem.second) == tmp.end()){
                    vector<int> v;
                    tmp[rem.second] = v;
                }
                tmp[rem.second].push_back(rem.first->val);
                if(rem.first->left != nullptr)
                    q.push({rem.first->left, rem.second - 1});
                if(rem.first->right != nullptr)
                    q.push({rem.first->right, rem.second + 1});
            }
            for(auto &k : tmp){
                sort(k.second.begin(), k.second.end());
                if(mp.find(k.first) == mp.end()){
                    vector<int> v;
                    mp[k.first] = v;
                }
                for(int i : k.second)
                    mp[k.first].push_back(i);
            }
        }
        vector<vector<int>> vec;
        for(auto &k : mp)
            vec.push_back(k.second);
        return vec;
    }
};
