class Solution {
    public String reverseWords(String s) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()){
            if(ch == ' '){
                if(sb.length() > 0){
                    list.add(sb.toString());
                    sb = new StringBuilder();
                }
            } else
                sb.append(ch);
        }
        if(sb.length() > 0){
            list.add(sb.toString());
            sb = new StringBuilder();
        }
        for(int i = list.size() - 1; i >= 0; i--){
            sb.append(list.get(i));
            if(i > 0)
                sb.append(" ");
        }
        return sb.toString();            
    }
}
