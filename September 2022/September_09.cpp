class Solution {
public:
    int numberOfWeakCharacters(vector<vector<int>>& properties) {
        sort(properties.begin(), properties.end());
        set<int> st;
        int i = properties.size() - 1, ans = 0;
        while(i >= 0){
            int j = i;
            while(j >= 0 && properties[j][0] == properties[i][0])
                if(st.lower_bound(properties[j--][1] + 1) != st.end())
                    ans++;
            while(i > j)
                st.insert(properties[i--][1]);
        }
        return ans;
    }
};
