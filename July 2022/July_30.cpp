class Solution {
public:
    vector<string> wordSubsets(vector<string>& words1, vector<string>& words2) {
        vector<int> req(26, 0);
        for(string &word : words2){
            vector<int> tmp(26, 0);
            for(char &ch : word)
                tmp[ch - 'a']++;
            for(int i = 0; i < 26; i++)
                req[i] = max(req[i], tmp[i]);
        }
        vector<string> vec;
        for(string &word : words1){
            vector<int> tmp(26, 0);
            for(char &ch : word)
                tmp[ch - 'a']++;
            bool flag = true;
            for(int i = 0; i < 26; i++)
                if(req[i] > tmp[i]){
                    flag = false;
                    break;
                }
            if(flag)
                vec.push_back(word);
        }
        return vec;
    }
};
