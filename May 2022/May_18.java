class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        graph = new ArrayList[n];
        for(int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();
        for(var v : connections){
            graph[v.get(0)].add(v.get(1));
            graph[v.get(1)].add(v.get(0));
        }
        
        list = new ArrayList<>();
        time = 0;
        dis = new int[n];
        min = new int[n];
        par = new int[n];
        vis = new boolean[n];
        
        helper(0);
        return list;
    }
    
    List<List<Integer>> list;
    List<Integer>[] graph;
    int[] dis, min, par;
    int time;
    boolean[] vis;
    
    private void helper(int node){
        dis[node] = min[node] = time++;
        vis[node] = true;
        
        for(int nbr : graph[node]){
            if(par[node] == nbr)
                continue;
            if(vis[nbr])
                min[node] = Math.min(min[node], dis[nbr]);
            else{
                par[nbr] = node;
                helper(nbr);
                min[node] = Math.min(min[node], min[nbr]);
                if(min[nbr] > dis[node]){
                    List<Integer> al = new ArrayList<>();
                    al.add(node);
                    al.add(nbr);
                    list.add(al);
                }
            }
        }
    }
}
