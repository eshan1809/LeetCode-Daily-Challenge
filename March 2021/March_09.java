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
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(root == null) return root;
        if(d == 2){
            TreeNode nodel = new TreeNode(v), noder = new TreeNode(v);
            nodel.left = root.left;
            noder.right = root.right;
            root.left = nodel;
            root.right = noder;
            return root;
        }
        if(d == 1){
            TreeNode node = new TreeNode(v);
            node.left = root;
            return node;
        }
        root.left = addOneRow(root.left, v, d-1);
        root.right = addOneRow(root.right, v, d-1);
        return root;
    }
}
