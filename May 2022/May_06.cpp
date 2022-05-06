class Solution {
public:
    string removeDuplicates(string s, int k) {
        int n = s.length();
        stack<char> st1;
        stack<int> st2;
        for(int i = 0; i < n; i++){
            if(!st1.empty() && st1.top() == s[i])
                st2.push(st2.top() + 1);
            else
                st2.push(1);
            st1.push(s[i]);
            if(st2.top() == k){
                for(int i = 0; i < k; i++)
                    st1.pop(), st2.pop();
            }
        }
        string str = "";
        while(!st1.empty())
            str += st1.top(), st1.pop();
        reverse(str.begin(), str.end());
        return str;
    }
};
