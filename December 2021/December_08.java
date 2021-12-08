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
    static int sum;

    public int helper(TreeNode node) {
        if(node == null)
            return 0;
        int ls = helper(node.left), rs = helper(node.right);
        int temp = Math.abs(ls - rs);
        sum += temp;
        return node.val+ls+rs;
    }

    public int findTilt(TreeNode root) {
        sum = 0;
        helper(root);
        return sum;
    }
}
