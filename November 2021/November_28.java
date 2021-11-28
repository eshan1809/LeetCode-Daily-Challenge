class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        boolean[] visited = new boolean[graph.length];
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> al = new ArrayList<>();
        al.add(0);
        helper(graph, 0, list, al, visited);
        return list;
    }
    private void helper(int[][] graph, int i, List<List<Integer>> list, List<Integer> al, boolean[] visited){
        if(i == graph.length - 1){
            list.add(new ArrayList<>(al));
            return;
        }
        visited[i] = true;
        for(int nbr : graph[i]){
            al.add(nbr);
            helper(graph, nbr, list, al, visited);
            al.remove(al.size() - 1);
        }
        visited[i] = false;
    }
}
