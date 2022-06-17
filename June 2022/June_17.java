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
    public int minCameraCover(TreeNode root) {
        ans = 0;
        if(helper(root) == 2)
            ans++;
        return ans;
    }
    
    int ans;
    
    private int helper(TreeNode root){
        int left = (root.left == null ? 1 : helper(root.left));
        int right = (root.right == null ? 1 : helper(root.right));
        
        if(left == 2 || right == 2){
            ans++;
            return 0;
        }
        
        if(left == 0 || right == 0)
            return 1;
        return 2;
    }
}
