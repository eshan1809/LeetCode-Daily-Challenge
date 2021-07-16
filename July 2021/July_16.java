class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int i = 0;
        while(i < nums.length - 3){
            int j = i + 1;
            while(j < nums.length - 2){
                int a = j + 1, b = nums.length - 1;
                while(a < b){
                    if(nums[i] + nums[j] + nums[a] + nums[b] == target){
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[a]);
                        list.add(nums[b]);
                        ans.add(list);
                        a++;
                        while(a < b && nums[a] == nums[a - 1]) a++;
                    } else if(nums[i] + nums[j] + nums[a] + nums[b] < target) a++;
                    else b--;
                }
                j++;
                while(j < nums.length - 2 && nums[j] == nums[j - 1]) j++;
            }
            i++;
            while(i < nums.length - 3 && nums[i] == nums[i - 1]) i++;
        }
        return ans;
    }
}
