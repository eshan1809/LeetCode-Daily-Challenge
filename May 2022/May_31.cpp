class Solution {
public:
    bool hasAllCodes(string s, int k) {
        int sz = 1 << k, idx = 0, mask = sz - 1;
        vector<bool> has(sz, false);
        for(int i = 0; i < s.length(); i++){
            idx <<= 1;
            idx &= mask;
            idx += s[i] - '0';
            if(i >= k - 1 && !has[idx]){
                has[idx] = true;
                if(--sz == 0)
                    return true;
            }
        }
        return false;
    }
};
