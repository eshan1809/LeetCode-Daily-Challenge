class NumArray {
public:
    int n;
    vector<int> arr, tree;
    
    void build(int id, int start, int end){
        if(start == end)
            tree[id] = arr[start];
        else{
            int mid = (start + end) / 2, left = 2 * id, right = left + 1;
            build(left, start, mid);
            build(right, mid + 1, end);
            tree[id] = tree[left] + tree[right];
        }
    }
    
    NumArray(vector<int>& nums) {
        n = nums.size();
        arr = nums;
        tree.resize(4 * n, 0);
        build(1, 0, n - 1);
    }
    
    void update(int id, int start, int end, int idx, int val){
        if(start == end){
            tree[id] = val;
            return;
        }
        if(idx < start || idx > end)
            return;
        int mid = (start + end) / 2, left = 2 * id, right = left + 1;
        if(idx <= mid)
            update(left, start, mid, idx, val);
        else
            update(right, mid + 1, end, idx, val);
        tree[id] = tree[left] + tree[right];
    }
    
    void update(int index, int val) {
        update(1, 0, n - 1, index, val);
    }
    
    int sum(int id, int start, int end, int left, int right){
        if(right < start || end < left)
            return 0;
        if((left <= start && end <= right))
            return tree[id];
        if(start == end)
            return tree[id];
        int mid = (start + end) / 2;
        return sum(2 * id, start, mid, left, right) + sum(2 * id + 1, mid + 1, end, left, right);
    }
    
    int sumRange(int left, int right) {
        return sum(1, 0, n - 1, left, right);
    }
};

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray* obj = new NumArray(nums);
 * obj->update(index,val);
 * int param_2 = obj->sumRange(left,right);
 */
