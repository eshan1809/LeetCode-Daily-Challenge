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
    public int kthSmallest(TreeNode root, int k) {
        i = 0;
        helper(root, k);
        return ans;
    }
    
    int i, ans;
    
    private void helper(TreeNode root, int k){
        if(root == null)
            return;
        helper(root.left, k);
        if(++i == k){
            ans = root.val;
            return;
        }
        helper(root.right, k);
    }
}
