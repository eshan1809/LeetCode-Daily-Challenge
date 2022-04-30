class Solution {
    class Pair{
        String end;
        double val;
        Pair(String a, double b){
            end = a;
            val = b;
        }
    }
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Pair>> map = new HashMap<>();
        for(int i = 0; i < equations.size(); i++){
            if(!map.containsKey(equations.get(i).get(0)))
                map.put(equations.get(i).get(0), new ArrayList<>());
            if(!map.containsKey(equations.get(i).get(1)))
                map.put(equations.get(i).get(1), new ArrayList<>());
            map.get(equations.get(i).get(0)).add(new Pair(equations.get(i).get(1), values[i]));
            map.get(equations.get(i).get(1)).add(new Pair(equations.get(i).get(0), 1 / values[i]));
        }
        
        int n = queries.size();
        double[] ans = new double[n];
        for(int i = 0; i < n; i++){
            if(!map.containsKey(queries.get(i).get(0)) || !map.containsKey(queries.get(i).get(1))){
                ans[i] = -1.0;
                continue;
            }
            List<Pair> l1 = new ArrayList<>(), l2 = new ArrayList<>();
            Set<String> vis = new HashSet<>();
            find(queries.get(i).get(0), 1.0 , map, l1, vis);
            find(queries.get(i).get(1), 1.0 , map, l2, vis);            
            boolean flag = false;
            for(Pair p1 : l1){
                for(Pair p2 : l2)
                    if(p1.end.equals(p2.end)){
                        ans[i] = p1.val / p2.val;
                        flag = true;
                        break;
                    }
                if(flag)
                    break;
            }
            if(!flag)
                ans[i] = -1.0;
        }
        return ans;
    }
    
    private void find(String s, double d, Map<String, List<Pair>> map, List<Pair> list, Set<String> vis){
        vis.add(s);
        list.add(new Pair(s, d));
        for(Pair nbr : map.get(s))
            if(!vis.contains(nbr.end))
                find(nbr.end, d * nbr.val, map, list, vis);
        vis.remove(s);
    }
}
