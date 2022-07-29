class Solution {
public:
    vector<string> findAndReplacePattern(vector<string>& words, string pattern) {
        int n = pattern.length();
        vector<string> vec;
        int arr[26], rev[26];
        for(string &word : words){
            memset(arr, -1, sizeof(arr));
            memset(rev, -1, sizeof(rev));
            bool flag = true;
            for(int i = 0; i < n; i++){
                char ch1 = word[i], ch2 = pattern[i];
                if(arr[ch1 - 'a'] == -1 && rev[ch2 - 'a'] == -1){
                    arr[ch1 - 'a'] = ch2 - 'a';
                    rev[ch2 - 'a'] = ch1 - 'a';
                } else if(arr[ch1 - 'a'] != ch2 - 'a' && rev[ch2 - 'a'] != ch1 - 'a'){
                    flag = false;
                    break;
                }
            }
            if(flag)
               vec.push_back(word);
        }
        return vec;
    }
};
