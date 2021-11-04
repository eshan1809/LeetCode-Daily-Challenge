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
    public void helper(TreeNode root, int[] A){
        if(root == null)
            return;
        if(root.left != null && root.left.left == null && root.left.right == null)
            A[0] += root.left.val;
        else
            helper(root.left, A);
        helper(root.right, A);
    }
    public int sumOfLeftLeaves(TreeNode root) {
        int[] A = new int[1];
        helper(root, A);
        return A[0];
    }
}
