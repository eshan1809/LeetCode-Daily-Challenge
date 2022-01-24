class Solution {
    public boolean detectCapitalUse(String word) {
        return allSame(word) || (Character.isUpperCase(word.charAt(0)) && allSame(word.substring(1)));
    }
    
    private boolean allSame(String word){
        boolean isSmall = Character.isLowerCase(word.charAt(0));
        for(char ch : word.toCharArray()){
            if(Character.isLowerCase(ch) != isSmall)
                return false;
        }
        return true;
    }
}
