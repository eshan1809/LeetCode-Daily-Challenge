class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> list = new ArrayList<>();
        for(int c = 0; c < nums.length && nums[c] <= 0; c++){
            int a = c + 1;
            int b = nums.length - 1;
            while(a < b){
                int sum = nums[a] + nums[b] + nums[c];
                if (sum < 0)
                    a++;
                else if(sum > 0)
                    b--;
                else{
                    ArrayList<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[c]);
                    triplet.add(nums[a]);
                    triplet.add(nums[b]);
                    list.add(triplet);
                    a++;
					          while(a < b && nums[a] == nums[a-1])
                        a++;
                }
            }
            while(c + 1 < nums.length && nums[c] == nums[c + 1])
                c++;
        }
        return list;
    }
}
