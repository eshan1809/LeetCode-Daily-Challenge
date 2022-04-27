class Solution {
public:
    int find(vector<int> &parent, int x){
        if(parent[x] == x)
            return x;
        return parent[x] = find(parent, parent[x]);
    }
    
    bool merge(vector<int> &parent, vector<int> &rank, int x, int y){
        int lx = find(parent, x), ly = find(parent, y);
        if(lx == ly)
            return false;
        if(rank[lx] > rank[ly])
            parent[ly] = lx;
        else if(rank[lx] < rank[ly])
            parent[lx] = ly;
        else{
            parent[lx] = ly;
            rank[ly]++;
        }
        return true;
    }
    
    string smallestStringWithSwaps(string s, vector<vector<int>>& pairs) {
        int n = s.length();
        
        vector<int> parent(n), rank(n);
        for(int i = 0; i < n; i++){
            parent[i] = i;
            rank[i] = 1;
        }
        
        for(auto &pair : pairs)
            merge(parent, rank, pair[0], pair[1]);
        
        unordered_map<int, vector<int>> mp;
        for(int i = 0; i < n; i++)
            mp[find(parent, i)].push_back(i);
        
        for(auto &k : mp){
            vector<int> arr(26, 0);
            for(auto &i : k.second)
                arr[s[i] - 'a']++;
            
            int x = 0;
            for(auto &i : k.second){
                while(arr[x] == 0)
                    x++;
                s[i] = (char)('a' + x);
                arr[x]--;
            }
        }
        
        return s;
    }
};
