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
    public int height(TreeNode root){
        if(root == null)
            return -1;
        return Math.max(height(root.left), height(root.right)) + 1;
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null)
            return -1;
        int diaOfLeft = diameterOfBinaryTree(root.left), diaOfRight = diameterOfBinaryTree(root.right);
        int myDia = height(root.left) + height(root.right) + 2;
        return Math.max(Math.max(diaOfLeft, diaOfRight), myDia);
    }
}
