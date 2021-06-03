class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        long maxHor = horizontalCuts[0], maxVer = verticalCuts[0];
        for(int i = 1; i < horizontalCuts.length; i++)
            maxHor = Math.max(maxHor, horizontalCuts[i] - horizontalCuts[i - 1]);
        maxHor = Math.max(maxHor, h - horizontalCuts[horizontalCuts.length - 1]);
        for(int i = 1; i < verticalCuts.length; i++)
            maxVer = Math.max(maxVer, verticalCuts[i] - verticalCuts[i - 1]);
        maxVer = Math.max(maxVer, w - verticalCuts[verticalCuts.length - 1]);
        return (int)((maxHor * maxVer) % 1000000007);
    }
}
