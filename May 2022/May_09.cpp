class Solution {
public:
    string keys[8] = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tvu", "wxyz"};
    vector<string> ans;
    
    void helper(string digits, int i, string ssf){
        if(i == digits.length()){
            if(ssf.length() > 0)
                ans.push_back(ssf);
            return;
        }
        int idx = digits[i] - '2';
        for(int j = 0; j < keys[idx].length(); j++)
            helper(digits, i + 1, ssf + keys[idx][j]);
    }
    
    vector<string> letterCombinations(string digits) {
        helper(digits, 0, "");
        return ans;
    }
};
