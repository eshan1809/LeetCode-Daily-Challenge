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
    public TreeNode helper(TreeNode root, int val){
        if(root == null)
            return new TreeNode(val);
        if(val <= root.val)
            root.left = helper(root.left, val);
        else
            root.right = helper(root.right, val);
        return root;
    }
    
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = null;
        for(int i : preorder)
            root = helper(root, i);
        return root;
    }
}
