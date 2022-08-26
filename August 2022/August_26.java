class Solution {
    public boolean reorderedPowerOf2(int n) {
        String s = String.valueOf(n);
        for(int i = 0; i < 31; i++){
            String c = String.valueOf((1 << i));
            int[] arr = new int[10];
            for(char ch : s.toCharArray())
                arr[ch - '0']++;
            for(char ch : c.toCharArray())
                arr[ch - '0']--;
            boolean flag = true;
            for(int j = 0; j < 10; j++)
                if(arr[j] != 0){
                    flag = false;
                    break;
                }
            if(flag)
                return true;
        }
        return false;
    }
}
