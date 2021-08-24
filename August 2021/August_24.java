class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        String[] str1 = num1.split("\\+|i"), str2 = num2.split("\\+|i");
        int real1 = Integer.parseInt(str1[0]), real2 = Integer.parseInt(str2[0]);
        int img1 = Integer.parseInt(str1[1]);
        int img2 = Integer.parseInt(str2[1]);
        int realAns = real1 * real2 - img1 * img2;
        int imgAns = real1 * img2 + real2 * img1;
        return realAns + "+" + imgAns + "i";
    }
}
