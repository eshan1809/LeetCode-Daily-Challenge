class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        unordered_set<int> hs;
        for(int i : nums)
            hs.insert(i);
        int ans = 0;
        for(int i : nums){
            if(hs.find(i - 1) == hs.end()){
                int curr = 1, j = i;
                while(hs.find(j + 1) != hs.end()){
                    j++;
                    curr++;
                }
                ans = max(ans, curr);
            }
        }
        return ans;
    }
};
