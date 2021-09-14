class Solution {
    public String reverseOnlyLetters(String s) {
        char[] arr = s.toCharArray();
        int i = 0, j = arr.length - 1;
        while(i < j){
            if(!Character.isAlphabetic(arr[i]))
                i++;
            else if(!Character.isAlphabetic(arr[j]))
                j--;
            else if(Character.isAlphabetic(arr[i]) && Character.isAlphabetic(arr[j])){
                char ch = arr[i];
                arr[i] = arr[j];
                arr[j] = ch;
                i++;
                j--;
            }
        }
        return String.valueOf(arr);
    }
}
