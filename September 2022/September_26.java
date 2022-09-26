class Solution {
    private int[] parent, rank;
    
    public boolean equationsPossible(String[] equations) {
        List<String> equalSet = new ArrayList<>(), unequalSet = new ArrayList<>();
        for(String eq : equations)
            if(eq.charAt(1) == '=')
                equalSet.add(eq);
            else
                unequalSet.add(eq);

        parent = new int[26];
        rank = new int[26];
        for(int i = 0; i < 26; i++)
            parent[i] = i;
        for(String eq : equalSet)
            union(eq.charAt(0) - 'a', eq.charAt(3) - 'a');
        for(String eq : unequalSet)
            if(find(eq.charAt(0) - 'a') == find(eq.charAt(3) - 'a'))
                return false;
        return true;
    }

    private int find(int x){
        if(parent[x] == x)
            return x;
        int l = find(parent[x]);
        parent[x] = l;
        return l;
    }

    private void union(int a, int b){
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
}
