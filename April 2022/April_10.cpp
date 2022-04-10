class Solution {
public:
    int calPoints(vector<string>& ops) {
        vector<int> arr;
        for(auto &op : ops){
            if(op == "+")
                arr.push_back(arr[arr.size() - 1] + arr[arr.size() - 2]);
            else if(op == "D")
                arr.push_back(2 * arr[arr.size() - 1]);
            else if(op == "C")
                arr.pop_back();
            else
                arr.push_back(stoi(op));
        }
        
        int ans = 0;
        for(auto &score : arr)
            ans += score;
        return ans;
    }
};
