class Solution {
    List<Integer>[] graph;
    int n;
    int[] ans, count;
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        this.n = n;
        graph = new ArrayList[n];
        for(int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();
        for(int i = 0; i < n - 1; i++){
            int u = edges[i][0], v = edges[i][1];
            graph[u].add(v);
            graph[v].add(u);
        }
        ans = new int[n];
        count = new int[n];
        Arrays.fill(count, 1);
        dfs1(0, -1);
        dfs2(0, -1);
        return ans;
    }
    
    private void dfs1(int node, int parent) {
        for(int child : graph[node]){
            if(child != parent){
                dfs1(child, node);
                count[node] += count[child];
                ans[node] += ans[child] + count[child];
            }
        }
    }
    
    private void dfs2(int node, int parent) {
        for(int child : graph[node]){
            if(child != parent) {
                ans[child] = ans[node] - count[child] + n - count[child];
                dfs2(child, node);
            }
        }
    }
}
