class NumArray {

    public NumArray(int[] nums) {
        n = nums.length;
        arr = nums;
        tree = new int[4 * n];
        build(1, 0, n - 1);
    }
    
    int n;
    int[] arr, tree;
    
    private void build(int id, int start, int end){
        if(start == end)
            tree[id] = arr[start];
        else{
            int mid = (start + end) / 2, left = 2 * id, right = left + 1;
            build(left, start, mid);
            build(right, mid + 1, end);
            tree[id] = tree[left] + tree[right];
        }
    }
    
    public void update(int index, int val) {
        update(1, 0, n - 1, index, val);
    }
    
    private void update(int id, int start, int end, int idx, int val){
        if(start == end){
            tree[id] = val;
            return;
        }
        if(idx > end || idx < start)
            return;
        int mid = (start + end) / 2;
        if(idx <= mid)
            update(2 * id, start, mid, idx, val);
        else
            update(2 * id + 1, mid + 1, end, idx, val);
        tree[id] = tree[2 * id] + tree[2 * id + 1];
    }
    
    public int sumRange(int left, int right) {
        return sum(1, 0, n - 1, left, right);
    }
    
    private int sum(int id, int start, int end, int left, int right){
        if(right < start || end < left)
            return 0;
        if(left <= start && end <= right)
            return tree[id];
        if(start == end)
            return tree[id];
        int mid = (start + end) / 2;
        return sum(id * 2, start, mid, left, right) + sum(id * 2 + 1, mid + 1, end, left, right);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
