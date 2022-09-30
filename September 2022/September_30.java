class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        int n = buildings.length;
        int[][] arr = new int[n << 1][2];
        for(int i = 0; i < (n << 1); i += 2){
            arr[i] = new int[]{buildings[i >> 1][0], -buildings[i >> 1][2]};
            arr[i + 1] = new int[]{buildings[i >> 1][1], buildings[i >> 1][2]};
        }
        Arrays.sort(arr, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                if(a[0] != b[0])
                    return a[0] - b[0];
                return a[1] - b[1];
            }
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(0);
        List<List<Integer>> list = new ArrayList<>();
        int curr = 0;
        for(int i = 0; i < (n << 1); i++){
            if(arr[i][1] < 0){
                pq.add(-arr[i][1]);
                if(curr != pq.peek()){
                    curr = pq.peek();
                    List<Integer> al = new ArrayList<>();
                    al.add(arr[i][0]);
                    al.add(curr);
                    list.add(al);
                }
            } else{
                pq.remove(arr[i][1]);
                if(curr != pq.peek()){
                    curr = pq.peek();
                    List<Integer> al = new ArrayList<>();
                    al.add(arr[i][0]);
                    al.add(curr);
                    list.add(al);
                }
            }
        }
        return list;
    }
}
