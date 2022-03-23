class Solution {
    public int brokenCalc(int startValue, int target) {
        int count = 0;
        while(startValue < target){
            if((target & 1) == 1)
                target++;
            else
                target >>= 1;
            count++;
        }
        return count + startValue - target;
    }
}
