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
    private TreeNode helper(int postStart, int inStart, int inEnd, int[] postorder, int[] inorder) {
        if (postStart < 0 || inStart < inEnd)
            return null;
        TreeNode root = new TreeNode(postorder[postStart]);
        int index = inStart;
        for(; index >= inEnd; index--)
            if (inorder[index] == root.val)
                break;
        root.right = helper(postStart - 1, inStart, index + 1, postorder, inorder);
        root.left = helper(postStart - 1 + index - inStart, index - 1, inEnd, postorder, inorder);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(postorder.length - 1, inorder.length - 1, 0, postorder, inorder);
    }
}
