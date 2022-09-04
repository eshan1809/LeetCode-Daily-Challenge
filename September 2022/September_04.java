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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(root, 0));
        while(!q.isEmpty()){
            int size = q.size();
            Map<Integer, List<Integer>> tmp = new HashMap<>();
            while(size-- > 0){
                Pair rem = q.remove();
                if(!tmp.containsKey(rem.angle))
                    tmp.put(rem.angle, new ArrayList<>());
                tmp.get(rem.angle).add(rem.node.val);
                if(rem.node.left != null)
                    q.add(new Pair(rem.node.left, rem.angle - 1));
                if(rem.node.right != null)
                    q.add(new Pair(rem.node.right, rem.angle + 1));
            }
            for(int k : tmp.keySet()){
                Collections.sort(tmp.get(k));
                if(!map.containsKey(k))
                    map.put(k, new ArrayList<>());
                map.get(k).addAll(tmp.get(k));
            }
        }
        List<List<Integer>> list = new ArrayList<>();
        for(int k : map.keySet())
            list.add(map.get(k));
        return list;
    }
    class Pair{
        TreeNode node;
        int angle;
        Pair(TreeNode node, int angle){
            this.node = node;
            this.angle = angle;
        }
    }
}
