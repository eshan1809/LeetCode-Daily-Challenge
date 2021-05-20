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
        if(root == null) return new ArrayList();
        Queue<TreeNode> q = new ArrayDeque();
        q.add(root);
        q.add(new TreeNode(-10000));
        List<List<Integer>> mal = new ArrayList();
        List<Integer> al = new ArrayList();
        while(q.size() > 0){
            TreeNode t = q.remove();
            if(t.val == -10000 && q.size() != 0){
                q.add(new TreeNode(-10000));
                mal.add(new ArrayList(al));
                al = new ArrayList();
            }
            if(t.val != -10000){
                al.add(t.val);
                if(t.left != null) q.add(t.left);
                if(t.right != null) q.add(t.right);
            }
        }
        if(al.size() > 0) mal.add(new ArrayList(al));
        return mal;
    }
}
