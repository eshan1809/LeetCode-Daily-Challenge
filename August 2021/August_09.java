class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0, i = num1.length() - 1, j = num2.length() - 1;
        while(i >= 0 && j >= 0){
            int x = (num1.charAt(i) - '0') + (num2.charAt(j) - '0') + carry;
            carry = x / 10;
            x = x % 10;
            sb.append(x);
            i--;
            j--;
        }
        while(i >= 0){
            int x = (num1.charAt(i) - '0') + carry;
            carry = x / 10;
            x = x % 10;
            sb.append(x);
            i--;
        }
        while(j >= 0){
            int x = (num2.charAt(j) - '0') + carry;
            carry = x / 10;
            x = x % 10;
            sb.append(x);
            j--;
        }
        if(carry > 0) sb.append(carry);
        return sb.reverse().toString();
    }
}
