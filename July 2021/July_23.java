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
    private int countOne(TreeNode root){
        if(root == null) return 0;
        int cl = countOne(root.left), cr = countOne(root.right);
        if(cl == 0) root.left = null;
        if(cr == 0) root.right = null;
        return cr + cl + root.val;
    }
    public TreeNode pruneTree(TreeNode root) {
        if(countOne(root) == 0) return null;
        return root;
    }
}
