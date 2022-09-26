class Solution {
public:
    int parent[26], rank[26];
    
    int find(int x){
        if(parent[x] == x)
            return x;
        int l = find(parent[x]);
        parent[x] = l;
        return l;
    }
    
    void merge(int a, int b){
        int la = find(a), lb = find(b);
        if(rank[la] > rank[lb])
            parent[lb] = la;
        else if(rank[la] < rank[lb])
            parent[la] = lb;
        else{
            parent[la] = lb;
            rank[la]++;
        }
    }
    
    bool equationsPossible(vector<string>& equations) {
        for(int i = 0; i < 26; i++){
            parent[i] = i;
            rank[i] = 1;
        }
        for(string &eq : equations)
            if(eq[1] == '=')
                merge(eq[0] - 'a', eq[3] - 'a');
        for(string &eq : equations)
            if(eq[1] == '!' && find(eq[0] - 'a') == find(eq[3] - 'a'))
                return false;
        return true;
    }
};
