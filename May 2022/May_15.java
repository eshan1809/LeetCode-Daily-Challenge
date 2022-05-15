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
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        int ans = 0;
        while(!q.isEmpty()){
            int sum = 0, size = q.size();
            while(size-- > 0){
                TreeNode rem = q.remove();
                sum += rem.val;
                if(rem.left != null)
                    q.add(rem.left);
                if(rem.right != null)
                    q.add(rem.right);
            }
            ans = sum;
        }
        return ans;
    }
}
