class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        for(int i = releaseTimes.length - 1; i > 0; i--)
            releaseTimes[i] -= releaseTimes[i - 1];
        int maxidx = 0;
        for(int i = 1; i < releaseTimes.length; i++)
            if((releaseTimes[i] > releaseTimes[maxidx]) || (releaseTimes[i] == releaseTimes[maxidx] && keysPressed.charAt(i) > keysPressed.charAt(maxidx)))
                maxidx = i;
        return keysPressed.charAt(maxidx);
    }
}
