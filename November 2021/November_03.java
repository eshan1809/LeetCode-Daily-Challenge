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
    public void helper(TreeNode root, int nsf, int[] arr){
        if(root == null)
            return;
        if(root.left == null && root.right == null){
            arr[0] += nsf * 10 + root.val;
            return;
        }
        helper(root.left, nsf * 10 + root.val, arr);
        helper(root.right, nsf * 10 + root.val, arr);
    }
    public int sumNumbers(TreeNode root) {
        int[] arr = new int[1];
        helper(root, 0, arr);
        return arr[0];
    }
}
