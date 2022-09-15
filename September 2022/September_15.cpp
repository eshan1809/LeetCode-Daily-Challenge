class Solution {
public:
    vector<int> findOriginalArray(vector<int>& changed) {
        map<int, int> mp;
        for(int i : changed)
            mp[i]++;
        int n = changed.size();
        if((n & 1) == 1){
            vector<int> v;
            return v;
        }
        vector<int> ans (n / 2);
        int j = 0;
        sort(changed.begin(), changed.end());
        for(int i = 0; i < n; i++){
            if(mp.find(changed[i]) != mp.end() && mp.find(2 * changed[i]) != mp.end()){
                if(changed[i] == 0){
                    if(mp[0] > 2){
                        mp[0] -= 2;
                        ans[j++] = 0;
                    } else if(mp[0] == 2){
                        mp.erase(0);
                        ans[j++] = 0;
                    }
                } else{
                    if(mp[changed[i]] == 1)
                        mp.erase(changed[i]);
                    else
                        mp[changed[i]]--;
                    if(mp[2 * changed[i]] == 1)
                        mp.erase(2 * changed[i]);
                    else
                        mp[2 * changed[i]]--;
                    ans[j++] = changed[i];
                }
            }
        }
        if(j == n / 2)
            return ans;
        vector<int> v;
        return v;
    }
};
