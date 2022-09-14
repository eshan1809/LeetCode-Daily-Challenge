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
    public int pseudoPalindromicPaths (TreeNode root) {
        freq = new int[10];
        ans = 0;
        helper(root);
        return ans;
    }
    
    int[] freq;
    int ans;
    
    private void helper(TreeNode root){
        if(root.left == null && root.right == null){
            freq[root.val]++;
            int o = 0;
            for(int i : freq)
                if((i & 1) == 1)
                    o++;
            if(o <= 1)
                ans++;
            freq[root.val]--;
            return;
        }
        freq[root.val]++;
        if(root.left != null)
            helper(root.left);
        if(root.right != null)
            helper(root.right);
        freq[root.val]--;
    }
}
