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
    public void recoverTree(TreeNode root) {
        first = second = prev = null;
        helper(root);
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }
    
    TreeNode first, second, prev;
    
    private void helper(TreeNode root){
        if(root == null)
            return;
        helper(root.left);
        if(prev != null && prev.val > root.val){
            if(first == null)
                first = prev;
            second = root;
        }
        prev = root;
        helper(root.right);
    }
}
