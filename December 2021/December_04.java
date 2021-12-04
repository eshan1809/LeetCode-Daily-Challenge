class StreamChecker {
    class Node{
        Node[] children;
        boolean isEnd;
        Node(){
            children = new Node[26];
            isEnd = false;
        }
    }

    Node root;
    StringBuilder sb;

    public StreamChecker(String[] words) {
        root = new Node();
        sb = new StringBuilder();
        for(String word : words){
            Node curr = root;
            for(int i = word.length() - 1; i >= 0; i--){
                int idx = word.charAt(i) - 'a';
                if(curr.children[idx] == null)
                    curr.children[idx] = new Node();
                curr = curr.children[idx];
            }
            curr.isEnd = true;
        }
    }

    public boolean query(char letter) {
        sb.append(letter);
        Node curr = root;
        for(int i = sb.length() - 1; i >= 0; i--){
            int idx = sb.charAt(i) - 'a';
            if(curr.children[idx] == null)
                break;
            curr = curr.children[idx];
            if(curr.isEnd)
                return true;
        }
        return false;
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */
