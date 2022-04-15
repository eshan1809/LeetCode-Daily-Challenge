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
    public TreeNode trimBST(TreeNode root, int lo, int hi) {
        if(root == null)
            return root;
        if(root.val > hi)
            return trimBST(root.left, lo, hi);
        if(root.val < lo)
            return trimBST(root.right, lo, hi);
        root.left = trimBST(root.left, lo, hi);
        root.right = trimBST(root.right, lo, hi);
        return root;
    }
}
