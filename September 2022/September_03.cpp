class Solution {
public:
    void solution(int n, int k, int num, vector<int> &vec){
        if(n == 0){
            vec.push_back(num);
            return;
        }
        int prev = num % 10;
        if(k == 0)
            solution(n - 1, k, num * 10 + prev, vec);
        else{
            if(prev + k < 10)
                solution(n - 1, k, num * 10 + prev + k, vec);
            if(prev - k >= 0)
                solution(n - 1, k, num * 10 + prev - k, vec);
        }
    }
    vector<int> numsSameConsecDiff(int n, int k) {
        vector<int> vec;
        for(int i = 1; i < 10; i++)
            solution(n - 1, k, i, vec);
        return vec;
    }
};
