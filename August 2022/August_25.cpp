class Solution {
public:
    bool canConstruct(string ransomNote, string magazine) {
        vector<int> arr(26, 0);
        for(char &ch : magazine)
            arr[ch - 'a']++;
        for(char &ch : ransomNote)
            arr[ch - 'a']--;
        for(int i : arr)
            if(i < 0)
                return false;
        return true;
    }
};
