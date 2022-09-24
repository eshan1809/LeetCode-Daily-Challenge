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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        list = new ArrayList<>();
        helper(root, targetSum, 0, new ArrayList<>());
        return list;
    }
    
    List<List<Integer>> list;
    
    private void helper(TreeNode root, int targetSum, int sum, List<Integer> al){
        if(root == null)
            return;
        if(root.left == null && root.right == null){
            if(sum + root.val == targetSum){
                al.add(root.val);
                list.add(new ArrayList<>(al));
                al.remove(al.size() - 1);
            }
            return;
        }
        al.add(root.val);
        helper(root.left, targetSum, sum + root.val, al);
        helper(root.right, targetSum, sum + root.val, al);
        al.remove(al.size() - 1);
    }
}
