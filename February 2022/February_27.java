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
    public int widthOfBinaryTree(TreeNode root) {
        int ans = 0;
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(root, 1));
        while(!q.isEmpty()){
            int size = q.size(), min = 0, max = 0;
            for(int i = 0; i < size; i++){
                Pair rem = q.remove();
                if(i == 0)
                    min = rem.degree;
                if(i == size - 1)
                    max = rem.degree;
                if(rem.node.left != null)
                    q.add(new Pair(rem.node.left, 2 * rem.degree));
                if(rem.node.right != null)
                    q.add(new Pair(rem.node.right, 2 * rem.degree + 1));
            }
            ans = Math.max(ans, max - min + 1);
        }
        return ans;
    }
    
    class Pair{
        TreeNode node;
        int degree;
        Pair(TreeNode node, int degree){
            this.node = node;
            this.degree = degree;
        }
    }
}
