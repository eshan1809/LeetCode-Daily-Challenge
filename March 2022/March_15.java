class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        int open = 0;
        for(char ch : s.toCharArray()){
            if(ch == ')'){
                if(open > 0){
                    open--;
                    sb.append(ch);
                }
            } else{
                if(ch == '(')
                    open++;
                sb.append(ch);
            }
        }
        int i = sb.length() - 1;
        while(i >= 0 && open > 0){
            if(sb.charAt(i) == '('){
                sb.deleteCharAt(i);
                open--;
            }
            i--;
        }
        return sb.toString();
    }
}
