class Solution {
    public int minimumLengthEncoding(String[] words) {
        Node root = new Node();
        for(String word : words){
            Node curr = root;
            for(int i = word.length() - 1; i >= 0; i--){
                int ch = word.charAt(i) - 'a';
                if(curr.children[ch] == null)
                    curr.children[ch] = new Node();
                curr = curr.children[ch];
            }
        }
        
        ans = 0;
        helper(root, 0);
        return ans;
    }
    
    int ans;
    
    private void helper(Node curr, int len){
        boolean leaf = true;
        for(int i = 0; i < 26; i++){
            if(curr.children[i] != null){
                leaf = false;
                helper(curr.children[i], len + 1);
            }
        }
        if(leaf)
            ans += len + 1;
    }
    
    class Node{
        Node[] children;
        Node(){
            children = new Node[26];
        }
    }
}
