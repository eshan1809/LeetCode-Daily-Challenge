class Solution {
public:
    vector<int> findSubstring(string s, vector<string>& words) {
        vector<int> vec;
        map<string, int> mp;
        for(string &word : words)
            mp[word]++;
        int len = words[0].length(), tot = words.size();
        for(int l = 0; l < len; l++){
            map<string, int> check;
            int count = 0, p = l;
            for(int i = l; i + len <= s.length(); i += len){
                string curr = s.substr(i, len);
                if(mp.find(curr) == mp.end()){
                    check.clear();
                    p = i + len;
                    count = 0;
                } else{
                    check[curr]++;
                    count++;
                    while(mp[curr] < check[curr]){
                        string prev = s.substr(p, len);
                        check[prev]--;
                        p += len;
                        count--;
                    }
                    if(count == tot)
                        vec.push_back(p);
                }
            }
        }
        return vec;
    }
};
