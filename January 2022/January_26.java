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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> st1 = new Stack<>(), st2 = new Stack<>();
        while(true){
            while(root1 != null){
                st1.add(root1);
                root1 = root1.left;
            }
            while(root2 != null){
                st2.add(root2);
                root2 = root2.left;
            }
            if(!st1.isEmpty() && !st2.isEmpty()){
                if(st1.peek().val < st2.peek().val){
                    TreeNode rem = st1.pop();
                    list.add(rem.val);
                    root1 = rem.right;
                } else{
                    TreeNode rem = st2.pop();
                    list.add(rem.val);
                    root2 = rem.right;
                }
            } else if(!st1.isEmpty()){
                TreeNode rem = st1.pop();
                list.add(rem.val);
                root1 = rem.right;
            } else if(!st2.isEmpty()){
                TreeNode rem = st2.pop();
                list.add(rem.val);
                root2 = rem.right;
            } else
                return list;
        }
    }
}
