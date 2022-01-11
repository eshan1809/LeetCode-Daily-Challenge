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
    public int sumRootToLeaf(TreeNode root) {
        int sum = 0;
        for(String s : helper(root)){
            int j = 1;
            for(int i = s.length() - 1; i >= 0; i--){
                if(s.charAt(i) == '1')
                    sum += j;
                j = (j << 1);
            }
        }
        return sum;
    }
    
    private List<String> helper(TreeNode root){
        if(root == null)
            return new ArrayList<>();
        else if(root.left == null && root.right == null){
            List<String> al = new ArrayList<>();
            al.add(root.val + "");
            return al;
        } else{
            List<String> al = new ArrayList<>();
            for(String s : helper(root.left))
                al.add(root.val + s);
            for(String s : helper(root.right))
                al.add(root.val + s);
            return al;
        }
    }
}
