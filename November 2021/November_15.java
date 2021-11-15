class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, max = 0;
        ArrayList<Integer>[] list = new ArrayList[n];
        
        for(int i = 0; i < n; i++){
            list[i] = new ArrayList<>();
            list[i].add(nums[i]);
        }
        
        for(int i = 1; i < n; i++){
            int app = -1;
            for(int j = 0; j < i; j++){
                if(nums[j] % nums[i] == 0 || nums[i] % nums[j] == 0)
                    if(app == -1 || list[j].size() > list[app].size())
                        app = j;
            }
            if(app != -1){
                list[i] = new ArrayList<>(list[app]);
                list[i].add(nums[i]);
            }
            if(list[i].size() > list[max].size())
                max = i;
        }
        return list[max];
    }
}
