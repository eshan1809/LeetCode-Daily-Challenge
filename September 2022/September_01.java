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
    public int goodNodes(TreeNode root) {
        ans = 0;
        helper(root, root.val);
        return ans;
    }
    
    int ans;
    
    private void helper(TreeNode root, int max){
        if(root == null)
            return;
        if(root.val >= max)
            ans++;
        helper(root.left, Math.max(max, root.val));
        helper(root.right, Math.max(max, root.val));
    }
}
