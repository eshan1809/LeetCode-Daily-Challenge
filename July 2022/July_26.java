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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> l1 = helper(root, p), l2 = helper(root, q);
        int i1 = l1.size() - 1, i2 = l2.size() - 1;
        while(i1 >= 0 && i2 >= 0 && l1.get(i1) == l2.get(i2)){
            i1--;
            i2--;
        }
        return l1.get(i1 + 1);
    }
    
    private List<TreeNode> helper(TreeNode root, TreeNode p){
        if(root == null)
            return null;
        if(root == p){
            List<TreeNode> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        
        List<TreeNode> left = helper(root.left, p);
        if(left != null){
            left.add(root);
            return left;
        }
        List<TreeNode> right = helper(root.right, p);
        if(right != null){
            right.add(root);
            return right;
        }
        return null;
    }
}
