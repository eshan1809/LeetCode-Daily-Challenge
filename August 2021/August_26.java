class Solution {
    private class Pair{
        String node;
        int count;
        Pair(String str, int num){
            node = str;
            count = num;
        }
    }
    public boolean isValidSerialization(String preorder) {
        if(preorder.equals("#"))
            return true;
        String[] parts = preorder.split(",");
        Stack<Pair> st = new Stack<>();
        if(parts[0].equals("#"))
            return false;
        st.push(new Pair(parts[0], 0));
        for(int i = 1; i < parts.length; i++){
            if(st.isEmpty())
                return false;
            if(++(st.peek().count) == 2)
                st.pop();
            if(!parts[i].equals("#"))
                st.push(new Pair(parts[i], 0));
        }
        return st.isEmpty();
    }
}
