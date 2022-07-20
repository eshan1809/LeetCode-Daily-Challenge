class Solution {
public:
    int numMatchingSubseq(string s, vector<string>& words) {
        unordered_map<string, int> mp;
        for(string word : words)
            mp[word]++;
        int ans = 0;
        for(auto &p : mp){
            int j = 0;
            for(int i = 0; i < s.length(); i++){
                if(s[i] == p.first[j])
                    j++;
                if(j == p.first.length())
                    break;
            }
            if(j == p.first.length())
                ans += p.second;
        }
        return ans;
    }
};
