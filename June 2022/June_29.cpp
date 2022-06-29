class Solution {
public:
    static bool cmp(vector<int> &a, vector<int> &b){
        if(a[1] != b[1])
            return a[1] < b[1];
        return a[0] < b[0];
    }
    
    vector<vector<int>> reconstructQueue(vector<vector<int>>& people) {
        int n = people.size();
        sort(people.begin(), people.end(), cmp);
        vector<vector<int>> ans;
        int i = 0;
        while(i < n && people[i][1] == 0)
            ans.push_back(people[i++]);
        while(i < n){
            int count = 0;
            for(int j = 0; j < i; j++){
                if(people[i][0] <= ans[j][0])
                    count++;
                if(people[i][1] + 1 == count){
                    ans.insert(ans.begin() + j, people[i]);
                    break;
                }
            }
            if(people[i][1] >= count)
                ans.push_back(people[i]);
            i++;
        }
        return ans;
    }
};
