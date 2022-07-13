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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null)
            return list;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> al = new ArrayList<>();
            while(size-- > 0){
                TreeNode rem = q.remove();
                al.add(rem.val);
                if(rem.left != null)
                    q.add(rem.left);
                if(rem.right != null)
                    q.add(rem.right);
            }
            list.add(al);
        }
        return list;
    }
}
