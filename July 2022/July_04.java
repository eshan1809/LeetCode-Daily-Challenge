class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        if(n == 1)
            return 1;
        
        int[] ans = new int[n];
        List<Integer> list = new ArrayList<>();
        list.add(-1);
        if(ratings[0] <= ratings[1]){
            list.add(0);
            ans[0] = 1;
        }
        for(int i = 1; i < n - 1; i++)
            if(ratings[i] <= ratings[i - 1] && ratings[i] <= ratings[i + 1]){
                list.add(i);
                ans[i] = 1;
            }
        if(ratings[n - 1] <= ratings[n - 2]){
            list.add(n - 1);
            ans[n - 1] = 1;
        }
        list.add(n);
        
        for(int i = 0; i < list.size() - 1; i++){
            int s = list.get(i), e = list.get(i + 1);
            int prev = (s == -1 ? 0 : ratings[s]), next = (e == n ? 0 : ratings[e]);
            int a1 = (s == -1 ? 0 : ans[s]), a2 = (e == n ? 0 : ans[e]);
            while(s + 1 < e && ratings[s + 1] > prev){
                ans[s + 1] = ++a1;
                prev = ratings[++s];
            }
            while(e - 1 >= s && e - 1 > list.get(i) && ratings[e - 1] > next){
                ans[e - 1] = Math.max(ans[e - 1], ++a2);
                next = ratings[--e];
            }
        }
        
        int res = 0;
        for(int i = 0; i < n; i++)
            res += ans[i];
        return res;
    }
}
