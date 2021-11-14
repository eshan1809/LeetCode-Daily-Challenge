class CombinationIterator {
    List<String> list;
    int i;
    public CombinationIterator(String characters, int combinationLength) {
        list = new ArrayList();
        i = -1;
        generate(characters, combinationLength, "");
    }
    
    public void generate(String str, int n, String asf){
        if(str.length() == 0){
            if(asf.length() == n) list.add(asf);
            return;
        }
        generate(str.substring(1), n, asf + str.charAt(0));
        generate(str.substring(1), n, asf);
    }
    
    public String next() {
        return list.get(++i);
    }
    
    public boolean hasNext() {
        return list.size()-1 > i;
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
