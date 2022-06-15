class Solution {
public:
    static bool cmp(string &a, string &b){
        return a.length() < b.length();
    }
    
    bool possible(string &s, string &t){
        if(s.length() != t.length() + 1)
            return false;
        int diff = 0;
        for(int i = 0; i < t.length(); i++)
            while(s[i + diff] != t[i])
                if(++diff > 1)
                    return false;
        return true;
    }
    
    int longestStrChain(vector<string>& words) {
        sort(words.begin(), words.end(), cmp);
        int n = words.size(), ans = 0;
        int dp[n];
        for(int i = 0; i < n; i++){
            int x = 0;
            for(int j = 0; j < i; j++)
                if(possible(words[i], words[j]))
                    x = max(x, dp[j]);
            ans = max(ans, dp[i] = x + 1);
        }
        return ans;
    }
};
