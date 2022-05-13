/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* left;
    Node* right;
    Node* next;

    Node() : val(0), left(NULL), right(NULL), next(NULL) {}

    Node(int _val) : val(_val), left(NULL), right(NULL), next(NULL) {}

    Node(int _val, Node* _left, Node* _right, Node* _next)
        : val(_val), left(_left), right(_right), next(_next) {}
};
*/

class Solution {
public:
    Node* connect(Node* root) {
        if(root == nullptr)
            return root;
        queue<Node* > q;
        q.push(root);
        while(!q.empty()){
            int size = q.size();
            Node* prev = nullptr;
            while(size--){
                Node* rem = q.front();
                q.pop();
                if(prev != nullptr)
                    prev->next = rem;
                prev = rem;
                if(rem->left != nullptr)
                    q.push(rem->left);
                if(rem->right != nullptr)
                    q.push(rem->right);
            }
            prev->next = nullptr;
        }
        return root;
    }
};
