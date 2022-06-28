class Solution {
public:
    int minDeletions(string s) {
        vector<int> arr(26, 0);
        for(char &ch : s)
            arr[ch - 'a']++;
        sort(arr.begin(), arr.end());
        int ans = 0;
        for(int i = 25; i > 0; i--)
            if(arr[i - 1] >= arr[i] && arr[i - 1] != 0){
                if(arr[i] == 0){
                    ans += arr[i - 1];
                    arr[i - 1] = 0;
                } else{
                    ans += arr[i - 1] - arr[i] + 1;
                    arr[i - 1] = arr[i] - 1;
                }
            }
        return ans;
    }
};
