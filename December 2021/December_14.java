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
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null)
            return 0;
        if(root.val < high && root.val > low){
            int left = rangeSumBST(root.left, low, high);
            int right = rangeSumBST(root.right, low, high);
            return left + right + root.val;
        } else if(root.val >= high){
            int left = rangeSumBST(root.left, low, high);
            return (root.val == high) ? left + root.val : left;
        } else if(root.val <= low){
            int right = rangeSumBST(root.right, low, high);
            return (root.val == low) ? right + root.val : right;
        }
        return 0;
    }
}
