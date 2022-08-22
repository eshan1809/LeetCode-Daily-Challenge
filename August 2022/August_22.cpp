class Solution {
public:
    bool isPowerOfFour(int n) {
        if(n <= 0)
            return false;
        return pow(4, (int)(log(n) / log(4))) == n;
    }
};
