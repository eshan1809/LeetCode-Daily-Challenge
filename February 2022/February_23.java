/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        Map<Node, Node> map = new HashMap<>();
        generateAllNodes(node, map);
        cloneAllNodes(node, map);
        return map.get(node);
    }
    
    private void generateAllNodes(Node node, Map<Node, Node> map){
        if(node == null)
            return;
        map.put(node, new Node(node.val));
        for(Node n : node.neighbors)
            if(!map.containsKey(n))
                generateAllNodes(n, map);
    }
    
    private void cloneAllNodes(Node node, Map<Node, Node> map){
        for(Node n : map.keySet())
            for(Node n1 : n.neighbors)
                map.get(n).neighbors.add(map.get(n1));
    }
}
