class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Node root = new Node();
        
        for(String product : products){
            Node curr = root;
            for(char ch : product.toCharArray()){
                if(curr.children[ch - 'a'] == null)
                    curr.children[ch - 'a'] = new Node();
                curr = curr.children[ch - 'a'];
            }
            curr.isEnd = true;
        }
        
        List<List<String>> list = new ArrayList<>();
        Node curr = root;
        
        StringBuilder product  = new StringBuilder();
        for(char ch : searchWord.toCharArray()){
            if(curr.children[ch - 'a'] == null)
                break;
            curr = curr.children[ch - 'a'];
            
            product.append(ch);
            List<String> li = new ArrayList<>();
            getProducts(curr, li, product);
            list.add(li);
        }
        
        while(list.size() < searchWord.length())
            list.add(new ArrayList<>());
        return list;
    }
    
    public void getProducts(Node curr, List<String> li, StringBuilder product){
        if(li.size() == 3)
            return;
        
        if(curr.isEnd)
            li.add(product.toString());
        
        for(int i = 0; i < 26; i++)
            if(curr.children[i] != null){
                product.append((char)('a' + i));
                getProducts(curr.children[i], li, product);
                product.deleteCharAt(product.length() - 1);
            }
    }
    
    class Node{
        boolean isEnd;
        Node[] children;
        Node(){
            isEnd = false;
            children = new Node[26];
        }
    }
}
