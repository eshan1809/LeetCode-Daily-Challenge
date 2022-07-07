class Solution {
public:
    int l1, l2, l3;
    bool helper(string s1, string s2, string s3, int i1, int i2, vector<vector<int>> &dp){
        int i3 = i1 + i2;
        if(i3 == l3)
            return i1 == l1 && i2 == l2;
        if(dp[i1][i2] != -1)
            return dp[i1][i2];
        bool ans = false;
        if(i1 < l1 && s1[i1] == s3[i3])
            ans = helper(s1, s2, s3, i1 + 1, i2, dp);
        if(ans)
            return dp[i1][i2] = ans;
        if(i2 < l2 && s2[i2] == s3[i3])
            ans = helper(s1, s2, s3, i1, i2 + 1, dp);
        return dp[i1][i2] = ans;
    }
    bool isInterleave(string s1, string s2, string s3) {
        l1 = s1.length();
        l2 = s2.length();
        l3 = s3.length();
        vector<vector<int>> dp(l1 + 1, vector<int>(l2 + 1, -1));// -1->null, 0-> false, 1->true
        return helper(s1, s2, s3, 0, 0, dp);
    }
};
