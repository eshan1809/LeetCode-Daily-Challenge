class Solution {
public:
    bool reorderedPowerOf2(int n) {
        string s = to_string(n);
        for(int i = 0; i < 31; i++){
            string c = to_string(1 << i);
            vector<int> arr(10, 0);
            for(char &ch : s)
                arr[ch - '0']++;
            for(char &ch : c)
                arr[ch - '0']--;
            bool flag = true;
            for(int j = 0; j < 10; j++)
                if(arr[i] != 0){
                    flag = false;
                    break;
                }
            if(flag)
                return true;
        }
        return false;
    }
};
