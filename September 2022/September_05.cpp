/*
// Definition for a Node.
class Node {
public:
    int val;
    vector<Node*> children;

    Node() {}

    Node(int _val) {
        val = _val;
    }

    Node(int _val, vector<Node*> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
public:
    vector<vector<int>> levelOrder(Node* root) {
        vector<vector<int> > vec;
        queue<Node*> q;
        if(root != nullptr)
            q.push(root);
        while(!q.empty()){
            int size = q.size();
            vector<int> v;
            while(size-- > 0){
                Node* rem = q.front();
                q.pop();
                v.push_back(rem->val);
                for(auto &c : rem->children)
                    q.push(c);
            }
            vec.push_back(v);
        }
        return vec;
    }
};
