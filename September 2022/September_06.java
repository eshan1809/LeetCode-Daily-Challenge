/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode pruneTree(TreeNode root) {
        return helper(root) ? root : null;
    }
    private boolean helper(TreeNode root){
        if(root == null)
            return false;
        boolean l = helper(root.left), r = helper(root.right);
        if(l == false)
            root.left = null;
        if(r == false)
            root.right = null;
        return (l || r || (root.val == 1));
    }
}
