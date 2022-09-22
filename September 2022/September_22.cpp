class Solution {
public:
    string reverse(string s){
        string str = "";
        for(int i = s.length() - 1; i >= 0; i--)
            str += s[i];
        return str;
    }
    
    string reverseWords(string s) {
        string str = "", ans = "";
        for(int i = 0; i < s.length(); i++){
            if(s[i] == ' '){
                ans += reverse(str) + " ";
                str = "";
            } else
                str += s[i];
        }
        return ans + reverse(str);
    }
};
