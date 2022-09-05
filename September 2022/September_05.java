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
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<Node> q = new ArrayDeque<>();
        if(root != null)
            q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> al = new ArrayList<>();
            while(size-- > 0){
                Node rem = q.remove();
                al.add(rem.val);
                for(Node c : rem.children)
                    q.add(c);
            }
            list.add(al);
        }
        return list;
    }
}
