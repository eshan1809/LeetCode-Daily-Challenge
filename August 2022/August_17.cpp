class Solution {
public:
    int uniqueMorseRepresentations(vector<string>& words) {
        vector<string> arr = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.." };
        unordered_set<string> st;
        for(string &word : words){
            string s = "";
            for(char &ch : word)
                s += arr[ch - 'a'];
            st.insert(s);
        }
        return st.size();
    }
};
