class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        vector<int> freq(256, 0);
        int j = 0, len = 0;
        for(int i = 0; i < s.length(); i++){
            int ch = s[i];
            while(freq[ch] > 0)
                freq[s[j++]]--;
            freq[ch]++;
            len = max(len, i - j + 1);
        }
        return len;
    }
};
