class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for(String email : emails){
            StringBuilder sb = new StringBuilder();
            int i = -1;
            while(++i < email.length()){
                if(email.charAt(i) == '.')
                    continue;
                else if(email.charAt(i) == '+' || email.charAt(i) == '@')
                    break;
                else
                    sb.append(email.charAt(i));
            }
            while(i < email.length() && email.charAt(i) != '@')
                i++;
            sb.append(email.substring(i));
            set.add(sb.toString());
        }
        return set.size();
    }
}
