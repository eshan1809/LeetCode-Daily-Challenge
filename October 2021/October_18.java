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
    public static List<Integer> nodeToRootPath(TreeNode root, int data) {
        List<Integer> list = new ArrayList<>();
        if(root == null)
            return list;
        if(root.val == data){
            list.add(data);
            return list;
        }
        List<Integer> l1 = nodeToRootPath(root.left, data);
        if(l1.size() > 0){
            l1.add(root.val);
            return l1;
        }
        List<Integer> l2 = nodeToRootPath(root.right, data);
        if(l2.size() > 0){
            l2.add(root.val);
            return l2;
        }
        return list;
    }
    
    public boolean isCousins(TreeNode root, int x, int y) {
        List<Integer> lx = nodeToRootPath(root, x), ly = nodeToRootPath(root, y);
        if(lx.size() != ly.size())
            return false;
        return lx.get(1) != ly.get(1);
        
    }
}
