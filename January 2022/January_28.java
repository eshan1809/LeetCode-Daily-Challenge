class WordDictionary {
    
    class Node{
        Node[] children;
        boolean isEnd;
        Node(){
            children = new Node[26];
        }
    }
    
    Node root;

    public WordDictionary() {
        root = new Node();
    }
    
    public void addWord(String word) {
        Node curr = root;
        for(char ch : word.toCharArray()){
            if(curr.children[ch - 'a'] == null)
                curr.children[ch - 'a'] = new Node();
            curr = curr.children[ch - 'a'];
        }
        curr.isEnd = true;
    }
    
    public boolean search(String word) {
        return search(0, word, root);
    }
    
    private boolean search(int i, String word, Node curr){
        if(i == word.length())
            return curr.isEnd;
        if(word.charAt(i) == '.'){
            for(char c = 0; c < 26; c++){
                if(curr.children[c] != null){
                    if(search(i + 1, word, curr.children[c]))
                        return true;
                }
            }
        } else{
            if(curr.children[word.charAt(i) - 'a'] != null)
                return search(i + 1, word, curr.children[word.charAt(i) - 'a']);
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
