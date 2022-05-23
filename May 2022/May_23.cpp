class Solution {
public:
    int findMaxForm(vector<string>& strs, int m, int n) {
        int size = strs.size();
        vector<pair<int, int> > arr(size);
        for(int i = 0; i < size; i++){
            arr[i].first = arr[i].second = 0;
            for(auto &j : strs[i]){
                if(j == '0')
                    arr[i].first++;
                else
                    arr[i].second++;
            }
        }
        vector<vector<vector<int> > > dp(size, vector<vector<int> >(m + 1, vector<int>(n + 1, -1)));
        return helper(arr, 0, m, n, dp);
    }
    
    int helper(vector<pair<int, int> > &arr, int i, int m, int n, vector<vector<vector<int> > > &dp){
        if(i == arr.size())
            return 0;
        if(dp[i][m][n] != -1)
            return dp[i][m][n];
        int ans = helper(arr, i + 1, m, n, dp);
        if(arr[i].first <= m && arr[i].second <= n)
            ans = max(ans, 1 + helper(arr, i + 1, m - arr[i].first, n - arr[i].second, dp));
        return dp[i][m][n] = ans;
    }
};
