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
    public boolean isValidBST(TreeNode root) {
        isBST = true;
        helper(root);
        return isBST;
    }
    
    boolean isBST;
    
    private int[] helper(TreeNode root){
        int[] arr = new int[2];
        if(root.left == null)
            arr[0] = root.val;
        else{
            int[] left = helper(root.left);
            if(left[1] >= root.val)
                isBST = false;
            arr[0] = left[0];
        }
        if(root.right == null)
            arr[1] = root.val;
        else{
            int[] right = helper(root.right);
            if(right[0] <= root.val)
                isBST = false;
            arr[1] = right[1];
        }
        return arr;
    }
}
