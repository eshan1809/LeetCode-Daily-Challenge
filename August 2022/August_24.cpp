class Solution {
public:
    bool isPowerOfThree(int n) {
        if(n <= 0)
            return false;
        double x = log(n) / log(3);
        if(ceil(x) - x < x - floor(x))
            x = ceil(x);
        else
            x = floor(x);
        return pow(3, x) == n;
    }
};
