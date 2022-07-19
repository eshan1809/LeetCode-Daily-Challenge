class Solution {
public:
    vector<vector<int>> generate(int numRows) {
        vector<vector<int>> vec;
        for(int i = 1; i <= numRows; i++){
            vector<int> v;
            v.push_back(1);
            for(int j = 2; j < i; j++)
                v.push_back(vec[i - 2][j - 2] + vec[i - 2][j - 1]);
            if(i > 1)
                v.push_back(1);
            vec.push_back(v);
        }
        return vec;
    }
};
