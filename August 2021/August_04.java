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
    public void helper(TreeNode root, int targetSum, int stn, List<List<Integer>> list, List<Integer> al){
        if(root == null) return;
        al.add(root.val);
        if(root.left == null && root.right == null){
            if(stn + root.val == targetSum) list.add(new ArrayList<>(al));
        } else{
            helper(root.left, targetSum, stn + root.val, list, al);
            helper(root.right, targetSum, stn + root.val, list, al);
        }
        al.remove(al.size() - 1);
        
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> list = new ArrayList<>();
        helper(root, targetSum, 0, list, new ArrayList<>());
        return list;
    }
}
