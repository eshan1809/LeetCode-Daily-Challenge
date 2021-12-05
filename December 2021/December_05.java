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
    public class Pair{
        int sit, not;
        Pair(int a, int b){
            sit = a;
            not = b;
        }
    }

    public Pair helper(TreeNode root){
        if(root == null) return new Pair(0, 0);
        Pair left = helper(root.left), right = helper(root.right);
        return new Pair(left.not + right.not + root.val, Math.max(left.sit, left.not) + Math.max(right.sit, right.not));
    }
    
    public int rob(TreeNode root) {
        Pair p = helper(root);
        return Math.max(p.sit, p.not);
    }
}
