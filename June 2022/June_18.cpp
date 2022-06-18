class WordFilter {
public:
    class Node{
        public:
        unordered_map<int, Node*> mp;
        int idx;
        Node(){
            idx = -1;
        }
    };
    
    Node* root;
    
    WordFilter(vector<string>& words) {
        root = new Node();
        for(int idx = 0; idx < words.size(); idx++){
            Node* curr = root;
            curr->idx = idx;
            string word = words[idx];
            int n = word.length();
            for(int i = 0; i < n; i++){
                Node* tmp = curr;
                for(int j = i; j < n; j++){
                    int f = word[j] - 'a';
                    if(tmp->mp[f * 27 + 26] == nullptr)
                        tmp->mp[f * 27 + 26] = new Node();
                    tmp = tmp->mp[f * 27 + 26];
                    tmp->idx = idx;
                }
                
                tmp = curr;
                for(int j = n - i - 1; j >= 0; j--){
                    int r = word[j] - 'a';
                    if(tmp->mp[26 * 27 + r] == nullptr)
                        tmp->mp[26 * 27 + r] = new Node();
                    tmp = tmp->mp[26 * 27 + r];
                    tmp->idx = idx;
                }
                
                int f = word[i] - 'a', r = word[n - i - 1] - 'a';
                if(curr->mp[f * 27 + r] == nullptr)
                    curr->mp[f * 27 + r] = new Node();
                curr = curr->mp[f * 27 + r];
                curr->idx = idx;
            }
        }
    }
    
    int f(string prefix, string suffix) {
        int n = prefix.length(), m = suffix.length(), i = 0, j = m - 1;
        Node* curr = root;
        while(i < n && j >= 0){
            int f = prefix[i] - 'a', r = suffix[j] - 'a';
            if(curr->mp[f * 27 + r] == nullptr)
                return -1;
            curr = curr->mp[f * 27 + r];
            i++;
            j--;
        }
        while(i < n){
            int f = prefix[i] - 'a';
            if(curr->mp[f * 27 + 26] == nullptr)
                return -1;
            curr = curr->mp[f * 27 + 26];
            i++;
        }
        while(j >= 0){
            int r = suffix[j] - 'a';
            if(curr->mp[26 * 27 + r] == nullptr)
                return -1;
            curr = curr->mp[26 * 27 + r];
            j--;
        }
        return curr->idx;
    }
};

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter* obj = new WordFilter(words);
 * int param_1 = obj->f(prefix,suffix);
 */
