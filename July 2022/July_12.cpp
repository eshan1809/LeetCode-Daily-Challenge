class Solution {
public:
    int n, side;
    bool used[15];
    
    bool helper(int i, vector<int>& arr, int sum, int f){
        if(i == n){
            if(sum != side)
                return false;
            if(f == 3)
                return true;
            return helper(0, arr, 0, f + 1);
        }
        if(helper(i + 1, arr, sum, f))
            return true;
        if(!used[i] && sum + arr[i] <= side){
            used[i] = true;
            if(helper(i + 1, arr, sum + arr[i], f))
                return true;
            used[i] = false;
        }
        return false;
    }
    
    bool makesquare(vector<int>& matchsticks) {
        long sum = 0L;
        for(int i : matchsticks)
            sum += i;
        if(sum % 4 != 0)
            return false;
        side = (int)(sum / 4);
        n = matchsticks.size();
        memset(used, sizeof(used), false);
        return helper(0, matchsticks, 0, 0);
    }
};
