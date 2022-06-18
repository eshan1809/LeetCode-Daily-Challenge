class WordFilter {

    public WordFilter(String[] words) {
        root = new Node();
        for(int idx = 0; idx < words.length; idx++){
            Node curr = root;
            curr.idx = idx;
            String s = words[idx];
            int n = s.length();
            
            for(int i = 0; i < n; i++){
                Node tmp = curr;
                for(int j = i; j < n; j++){
                    int f = s.charAt(j) - 'a';
                    if(!tmp.map.containsKey(f * 27 + 26))
                        tmp.map.put(f * 27 + 26, new Node());
                    tmp = tmp.map.get(f * 27 + 26);
                    tmp.idx = idx;
                }
                
                tmp = curr;
                for(int j = n - i - 1; j >= 0; j--){
                    int r = s.charAt(j) - 'a';
                    if(!tmp.map.containsKey(26 * 27 + r))
                        tmp.map.put(26 * 27 + r, new Node());
                    tmp = tmp.map.get(26 * 27 + r);
                    tmp.idx = idx;
                }
                
                int f = s.charAt(i) - 'a', r = s.charAt(n - i - 1) - 'a';
                if(!curr.map.containsKey(f * 27 + r))
                    curr.map.put(f * 27 + r, new Node());
                curr = curr.map.get(f * 27 + r);
                curr.idx = idx;
            }
        }
    }
    
    public int f(String prefix, String suffix) {
        int n = prefix.length(), m = suffix.length(), i = 0, j = m - 1;
        Node curr = root;
        while(i < n && j >= 0){
            int f = prefix.charAt(i) - 'a', r = suffix.charAt(j) - 'a';
            if(!curr.map.containsKey(f * 27 + r))
                return -1;
            curr = curr.map.get(f * 27 + r);
            i++;
            j--;
        }
        while(i < n){
            int f = prefix.charAt(i) - 'a';
            if(!curr.map.containsKey(f * 27 + 26))
                return -1;
            curr = curr.map.get(f * 27 + 26);
            i++;
        }
        while(j >= 0){
            int r = suffix.charAt(j) - 'a';
            if(!curr.map.containsKey(26 * 27 + r))
                return -1;
            curr = curr.map.get(26 * 27 + r);
            j--;
        }
        return curr.idx;
    }
    
    Node root;
    
    public class Node{
        int idx;
        Map<Integer, Node> map;
        Node[][] children;
        Node(){
            map = new HashMap<>();
            idx = -1;
        }
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */
