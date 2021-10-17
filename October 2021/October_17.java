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
    public void dfs1(TreeNode root,int ts, int[] arr){
        if(root == null)
            return;
        dfs2(root, ts, arr);
        dfs1(root.left, ts, arr);
        dfs1(root.right, ts, arr);
    }
    
    public void dfs2(TreeNode root,int ts, int[] arr){
        if(root == null)
            return;
        if(root.val == ts)
            arr[0]++;
        dfs2(root.left,ts - root.val, arr);
        dfs2(root.right,ts - root.val, arr);
    }
    
    public int pathSum(TreeNode root, int targetSum) {
        int[] arr = new int[1];
        dfs1(root, targetSum, arr);
        return arr[0];
    }
}
