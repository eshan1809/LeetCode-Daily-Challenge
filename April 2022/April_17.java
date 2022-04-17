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
    public TreeNode increasingBST(TreeNode root) {
        inOrder(root);
        return ans;
    }
    
    TreeNode curr = null, ans = null;
    
    private void inOrder(TreeNode root){
        if(root == null)
            return;
        inOrder(root.left);
        root.left = null;
        if(curr != null)
            curr.right = root;
        else
            ans = root;
        curr = root;
        inOrder(root.right);
    }
}
