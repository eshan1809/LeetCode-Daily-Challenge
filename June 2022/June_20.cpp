class Solution {
public:
    class Node{
        public:
        vector<Node*> children{vector<Node*>(26, NULL)};
    };
    
    int ans;
    
    void helper(Node* curr, int len){
        bool leaf = true;
        for(int i = 0; i < 26; i++){
            if(curr->children[i] != NULL){
                leaf = false;
                helper(curr->children[i], len + 1);
            }
        }
        if(leaf)
            ans += len + 1;
    }
    
    int minimumLengthEncoding(vector<string>& words) {
        Node* root = new Node();
        for(string word : words){
            Node* curr = root;
            for(int i = word.length() - 1; i >= 0; i--){
                int ch = word[i] - 'a';
                if(curr->children[ch] == NULL)
                    curr->children[ch] = new Node();
                curr = curr->children[ch];
            }
        }
        
        ans = 0;
        helper(root, 0);
        return ans;
    }
};
