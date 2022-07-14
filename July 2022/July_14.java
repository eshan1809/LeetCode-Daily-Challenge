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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        n = inorder.length;
        id = 0;
        map = new HashMap<>();
        for(int i = 0; i < n; i++)
            map.put(inorder[i], i);
        return buildTree(preorder, inorder, 0, n - 1);
    }
    
    int n, id;
    Map<Integer, Integer> map;
    
    private TreeNode buildTree(int[] pre, int[] in, int l, int r){
        if(l > r)
            return null;
        int m = map.get(pre[id]);
        TreeNode node = new TreeNode(pre[id++]);
        node.left = buildTree(pre, in, l, m - 1);
        node.right = buildTree(pre, in, m + 1, r);
        return node;
    }

}
