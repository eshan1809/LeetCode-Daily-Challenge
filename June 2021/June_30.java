/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
     public List<TreeNode> nodeToRootPath(TreeNode root, TreeNode data) {
        List<TreeNode> list = new ArrayList<>();
        if(root == null) return list;
        if(root.val == data.val){
            list.add(root);
            return list;
        }
        
        List<TreeNode> l1 = nodeToRootPath(root.left, data);
        if(l1.size() > 0){
            l1.add(0, root);
            return l1;
        }
        
        List<TreeNode> l2 = nodeToRootPath(root.right, data);
        if(l2.size() > 0){
            l2.add(0, root);
            return l2;
        }
        return list;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> l1 = nodeToRootPath(root, p), l2 = nodeToRootPath(root, q);
        for(int i = 0; i < Math.min(l1.size(), l2.size()); i++)
            if(l1.get(i) != l2.get(i)) return l1.get(i - 1);
        return l1.get(Math.min(l1.size(), l2.size()) - 1);
    }
}
