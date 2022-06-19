class Solution {
public:
    class Node{
        public:
        bool isEnd;
        vector<Node*> children{vector<Node*>(26, nullptr)};
        Node(){
            isEnd = false;
        }
    };
    
    void getProducts(Node* curr, vector<string> &v, string &product){
        if(v.size() == 3)
            return;
        
        if(curr->isEnd)
            v.push_back(product);
        
        for(int i = 0; i < 26; i++)
            if(curr->children[i] != nullptr){
                product += (char)('a' + i);
                getProducts(curr->children[i], v, product);
                product.pop_back();
            }
    }
    
    vector<vector<string>> suggestedProducts(vector<string>& products, string searchWord) {
        Node* root = new Node();
        for(string &product : products){
            Node* curr = root;
            for(char &ch : product){
                if(curr->children[ch - 'a'] == nullptr)
                    curr->children[ch - 'a'] = new Node();
                curr = curr->children[ch - 'a'];
            }
            curr->isEnd = true;
        }
        
        vector<vector<string>> vec(searchWord.length(), vector<string>());
        string product = "";
        Node* curr = root;
        for(int i = 0; i < searchWord.length(); i++){
            char ch = searchWord[i];
            if(curr->children[ch - 'a'] == nullptr)
                break;
            curr = curr->children[ch - 'a'];
            product += ch;
            getProducts(curr, vec[i], product);
        }
        return vec;
    }
};
