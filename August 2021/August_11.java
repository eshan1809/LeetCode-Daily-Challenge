class Solution {
    public boolean canReorderDoubled(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length, k = 0;
        while (k < n && arr[k] < 0) k++;
        if (k % 2 != 0) return false;
        boolean[] used = new boolean[n];    
        if (k > 0) {
            for (int i = k - 1; i >= 0; i--) {
                if (used[i]) continue;
                int flag = 0;
                for (int j = i - 1; j >= 0; j--) {
                    if (used[j]) continue;
                    if (arr[j] == 2 * arr[i]) {
                        used[j] = true;
                        flag = 1;
                        break;
                    }
                }
                if (flag == 0) return false;
            }
        }
        for (int i = k; i < n; i++) {
            if (used[i]) continue;
            int flag = 0;
            for (int j = i + 1; j < n; j++) {
                if (used[j]) continue;
                if (arr[j] == 2 * arr[i]) {
                    used[j] = true;
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) return false;
        }
        return true;
    }
}
