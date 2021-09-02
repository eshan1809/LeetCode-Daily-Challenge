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
    public List<TreeNode> helper(int start, int end){
        List<TreeNode> list = new ArrayList<>();
        if(start > end)
            list.add(null);
        else{
            for(int i = start; i <= end; i++){
                List<TreeNode> left = helper(start, i - 1);
                List<TreeNode> right = helper(i + 1, end);
                for(TreeNode x : left)
                    for(TreeNode y : right)
                        list.add(new TreeNode(i, x, y));
            }
        }
        return list;
    }
    
    public List<TreeNode> generateTrees(int n) {
        return helper(1, n);
    }
}
