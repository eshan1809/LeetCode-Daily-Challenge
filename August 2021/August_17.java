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
    public int goodNodes(TreeNode root) {
        int[] ans = new int[1];
        helper(root, root.val, ans);
        return ans[0];
    }
    private void helper(TreeNode root, int max, int[] ans){
        if(root == null) return;
        if(root.val >= max) {
            max = root.val;
            ans[0]++;
        }
        helper(root.left, max, ans);
        helper(root.right, max, ans);
    }
}
