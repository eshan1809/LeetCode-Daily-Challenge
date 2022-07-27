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
    public void flatten(TreeNode root) {
        if(root == null)
            return;
        flatten(root.left);
        flatten(root.right);
        TreeNode left = root.left, right = root.right, tmp = root.left;
        if(tmp == null)
            return;
        root.right = left;
        root.left = null;
        while(tmp.right != null)
            tmp = tmp.right;
        tmp.right = right;
    }
}
