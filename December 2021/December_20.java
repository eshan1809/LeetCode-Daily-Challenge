class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> list = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for(int i = 1; i < arr.length; i++){
            if(min == (arr[i] - arr[i - 1])){
                list.add(new ArrayList<>(Arrays.asList(arr[i - 1], arr[i])));
            } else if((min > (arr[i] - arr[i - 1]))){
                list.clear();
                list.add(new ArrayList<>(Arrays.asList(arr[i - 1],arr[i])));
                min = (arr[i] - arr[i - 1]);
            }
        }
        return list;
    }
}
