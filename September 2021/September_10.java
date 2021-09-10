class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int ans = 0, n = nums.length;
		Map<Integer, Integer>[] map = new HashMap[n];
		for(int i = 0; i < n; i++)
		    map[i] = new HashMap<>();
		for(int i = 1; i < n; i++){
		    for(int j = 0; j < i; j++){
		        long diff = (long)nums[i] - (long)nums[j];
		        if(Integer.MIN_VALUE < diff && diff < Integer.MAX_VALUE){
		            int cd = (int)diff;
    		        ans += map[j].getOrDefault(cd, 0);
    		        map[i].put(cd, map[i].getOrDefault(cd, 0) + map[j].getOrDefault(cd, 0) + 1);
		        }
		    }
		}
		return ans;
    }
}
