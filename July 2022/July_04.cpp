class Solution {
public:
    int candy(vector<int>& ratings) {
        int n = ratings.size();
        if(n == 1)
            return 1;
        
        vector<int> vec, ans(n, 0);
        vec.push_back(-1);
        if(ratings[0] <= ratings[1]){
            vec.push_back(0);
            ans[0] = 1;
        }
        for(int i = 1; i < n - 1; i++)        
            if(ratings[i] <= ratings[i - 1] && ratings[i] <= ratings[i + 1]){
                vec.push_back(i);
                ans[i] = 1;
            }
        if(ratings[n - 1] <= ratings[n - 2]){
            vec.push_back(n - 1);
            ans[n - 1] = 1;
        }
        vec.push_back(n);
        
        for(int i = 0; i < vec.size() - 1; i++){
            int s = vec[i], e = vec[i + 1];
            int prev = (s == -1 ? 0 : ratings[s]), next = (e == n ? 0 : ratings[e]);
            int a1 = (s == -1 ? 0 : ans[s]), a2 = (e == n ? 0 : ans[e]);
            while(s + 1 < e && ratings[s + 1] > prev){
                ans[s + 1] = ++a1;
                prev = ratings[++s];
            }
            while(e - 1 >= s && e - 1 > vec[i] && ratings[e - 1] > next){
                ans[e - 1] = max(ans[e - 1], ++a2);
                next = ratings[--e];
            }
        }
        
        return accumulate(ans.begin(), ans.end(), 0);
    }
};
