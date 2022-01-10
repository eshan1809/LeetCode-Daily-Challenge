class Solution {
    public String addBinary(String a, String b) {
        int i1 = a.length() - 1, i2 = b.length() - 1, carry = 0, sum = 0;
        StringBuilder sb = new StringBuilder();
        while(i1 >= 0 && i2 >= 0){
            int ai = a.charAt(i1) - '0', bi = b.charAt(i2) - '0';
            sum = (ai + bi + carry) % 2;
            carry = (ai + bi + carry) / 2;
            sb.append(sum);
            i1--;
            i2--;
        }
        while(i1 >= 0){
            int ai = a.charAt(i1) - '0';
            sum = (ai + carry) % 2;
            carry = (ai + carry) / 2;
            sb.append(sum);
            i1--;
        }
        while(i2 >= 0){
            int bi = b.charAt(i2) - '0';
            sum = (bi + carry) % 2;
            carry = (bi + carry) / 2;
            sb.append(sum);
            i2--;
        }
        if(carry == 1)
            sb.append(carry);
        return sb.reverse().toString();
    }
}
