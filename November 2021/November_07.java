class Solution {
    public String addStrings(String num1, String num2) {
        String str = "";
        int carry = 0, i = num1.length() - 1, j = num2.length() - 1;
        while(i >= 0 && j >= 0){
            int x = (num1.charAt(i) - '0') + (num2.charAt(j) - '0') + carry;
            carry = x / 10;
            x = x % 10;
            str = x + str;
            i--;
            j--;
        }
        while(i >= 0){
            int x = (num1.charAt(i) - '0') + carry;
            carry = x / 10;
            x = x % 10;
            str = x + str;
            i--;
        }
        while(j >= 0){
            int x = (num2.charAt(j) - '0') + carry;
            carry = x / 10;
            x = x % 10;
            str = x + str;
            j--;
        }
        if(carry > 0)
            str = carry + str;
        return str;
    }
    
    public String multiplyByDigit(String num1, int x){
        String str = "";
        int i = num1.length() - 1, carry = 0;
        while(i >= 0){
            int n = (num1.charAt(i--) - '0') * x + carry;
            carry = n / 10;
            n %= 10;
            str = n + str;
        }
        if(carry > 0)
            str = carry + str;
        return str;
    }
    
    public String multiply(String num1, String num2) {
        int n = num2.length(), i = n - 1;
        String ans = "";
        while(i >= 0){
            String subAns = multiplyByDigit(num1, num2.charAt(i--) - '0');
            for(int j = i + 2; j < n; j++)
                subAns += '0';
            ans = addStrings(ans, subAns);
        }
        i = 0;
        while(i < ans.length() && ans.charAt(i) == '0')
            i++;
        if(ans.length() == i)
            return "0";
        return ans.substring(i);
    }
}
