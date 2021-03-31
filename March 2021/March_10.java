class Solution {
    public String intToRoman(int num) {
        StringBuilder numeralString = new StringBuilder();
        intToRomanRecursive(num, numeralString);
        return numeralString.toString();
    }
    
    private void intToRomanRecursive(int remainder, StringBuilder numeralString) {
        if(remainder <= 0) return;
        int quotient;
        if((quotient = remainder / 1000) > 0){
            for (int i = 0; i < quotient; i++) numeralString.append('M');
            intToRomanRecursive(remainder - quotient * 1000, numeralString);
            return;
        }
        if((quotient = remainder / 100) > 0){
            middleCase(quotient, "MDC", numeralString);
            intToRomanRecursive(remainder - quotient * 100, numeralString);
            return;
        }
        if((quotient = remainder / 10) > 0){
            middleCase(quotient, "CLX", numeralString);
            intToRomanRecursive(remainder - quotient * 10, numeralString);
            return;
        }
        if((quotient = remainder / 1) > 0){
            middleCase(quotient, "XVI", numeralString);
            intToRomanRecursive(remainder - quotient * 1, numeralString);
            return;
        }
	  }
    
    private void middleCase(int quotient, String letters, StringBuilder numeralString){
        char tens = letters.charAt(0), fives = letters.charAt(1), ones = letters.charAt(2);
        if(quotient == 9){
            numeralString.append(ones);
            numeralString.append(tens);
        } else if(quotient >= 5){
            numeralString.append(fives);
            quotient -= 5;
            for(int i = 0; i < quotient; i++) numeralString.append(ones);
        } else if(quotient == 4){
            numeralString.append(ones);
            numeralString.append(fives);
        } else{
            for(int i = 0; i < quotient; i++) numeralString.append(ones);
        }
	  }
}
