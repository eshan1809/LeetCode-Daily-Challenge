class Solution {
public:
    int romanToInt(string s) {
        unordered_map<char, int> mp;
        mp['I'] = 1;
        mp['V'] = 5;
        mp['X'] = 10;
        mp['L'] = 50;
        mp['C'] = 100;
        mp['D'] = 500;
        mp['M'] = 1000;
        int num = mp[s[s.length() - 1]];
        for(int i = s.length() - 2; i >= 0; i--){
            int x = mp[s[i]];
            if(x >= mp[s[i + 1]])
                num += x;
            else
                num -= x;
        }
        return num;
    }
};
