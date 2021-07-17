class Solution {
    public int findPattern(int[] arr, int i, int j){
        while(j < arr.length)
            if(arr[i] == arr[j]){
                i++;
                j++;
            } else break;
        return j == arr.length ? i : -1;
    }
    public int[] threeEqualParts(int[] arr) {
        int count = 0, n = arr.length;
        int[] ans = new int[2];
        for(int i : arr)
            count += i;
        if(count % 3 != 0)
            return new int[]{-1, -1};
        if(count == 0)
            return new int[]{0, n - 1};
        int ones = count / 3, i1 = 0, i2 = n;
        while(ones > 0)
            ones -= arr[--i2];
        while(arr[i1] == 0)
            i1++;
        int x = findPattern(arr, i1, i2);
        if(x == -1)
            return new int[]{-1, -1};
        ans[0] = x - 1;
        while(arr[x] == 0)
            x++;
        int y = findPattern(arr, x, i2);
        if(y == -1)
            return new int[]{-1, -1};
        ans[1] = y;
        return ans;
    }
}
