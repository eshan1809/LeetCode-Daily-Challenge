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
    long ans;
    public int maxProduct(TreeNode root) {
        HashMap<TreeNode, Long> map = new HashMap<>();
        helper(root, map);
        ans = 0L;
        helper2(root, map, 0);
        return (int)(ans % 1000000007);
    }
    
    private long helper(TreeNode root, HashMap<TreeNode, Long> map){
        if(root == null)
            return 0;
        long left = helper(root.left, map), right = helper(root.right, map), sum = left + right + root.val;
        map.put(root, sum);
        return sum;
    }
    
    private void helper2(TreeNode root, Map<TreeNode, Long> map, long x){
        if(root.left != null){
            long z = (map.get(root) + x - map.get(root.left)) * map.get(root.left);
            ans = Math.max(ans, z);
            helper2(root.left, map, x + root.val + map.getOrDefault(root.right, 0L));
        }
        if(root.right != null){
            long z = (map.get(root) + x - map.get(root.right)) * map.get(root.right);
            ans = Math.max(ans, z);
            helper2(root.right, map, x + root.val + map.getOrDefault(root.left, 0L));
        }
    }
}
