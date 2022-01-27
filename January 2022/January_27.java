class Solution {
    class Trie{
        class Node{
            Node left, right;
        }
        
        final Node root;

        Trie(){
            root = new Node();
        }
        
        public void insert(int val){
            Node tmp = root;
            int bit = 30;
            while(bit >= 0){
                int mask = (1 << bit) & val;
                if(mask == 0){
                    if(tmp.left == null)
                        tmp.left = new Node();
                    tmp = tmp.left;
                } else{
                    if(tmp.right == null)
                        tmp.right = new Node();
                    tmp = tmp.right;
                }
                bit--;
            }
        }
        
        public int find(int val){
            Node tmp = root;
            int bit = 30, ans = 0;
            while(bit >= 0){
                int mask = (1 << bit);
                if((mask & val) == 0){
                    if(tmp.left != null)
                        tmp = tmp.left;
                    else{
                        tmp = tmp.right;
                        ans |= mask;
                    }
                } else{
                    if(tmp.right != null){
                        tmp = tmp.right;
                        ans |= mask;
                    } else
                        tmp = tmp.left;
                }
                bit--;
            }
            return ans;
        }
    }
    
    public int findMaximumXOR(int[] nums) {
        int ans = 0, n = nums.length;
        Trie t = new Trie();
        for(int i = 0; i < n; i++)
            t.insert(nums[i]);
        for(int i = 0; i < n; i++)
            ans = Math.max(ans, t.find(Integer.MAX_VALUE ^ nums[i]) ^ nums[i]);
        return ans;
    }
}
