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
    public int height(TreeNode node){
        if(node == null) return -1;
        return 1 + Math.max(height(node.left), height(node.right));
    }
    int sum;
    public int deepestLeavesSum(TreeNode root) {
        sum = 0;
        findSum(root, height(root));
        return sum;
    }
    public void findSum(TreeNode node, int k){
        if(node == null) return;
        if(k == 0){
            sum += node.val;
            return;
        }
        findSum(node.left, k - 1);
        findSum(node.right, k - 1);
    }
}
