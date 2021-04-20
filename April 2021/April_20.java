/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
  
    List<Integer> list;
  
    public List<Integer> preorder(Node root) {
        list = new ArrayList<>();
        getInOrder(root);
        return list;
    }
  
    public void getInOrder(Node root){
        if(root == null) return;
        list.add(root.val);
        for(Node child: root.children)
            getInOrder(child);
    }
}
