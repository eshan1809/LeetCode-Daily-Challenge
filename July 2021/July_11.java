class MedianFinder {
    List<Integer> list;
    /** initialize your data structure here. */
    public MedianFinder() {
        list = new ArrayList<>();
    }
    
    public void addNum(int num) {
        if(list.size() == 0){
            list.add(num);
            return;
        }
        int i = 0, j = list.size() - 1;
        while(i < j){
            int mid = (i + j) / 2;
            if(list.get(mid) > num) j = mid - 1;
            else i = mid + 1;
        }
        if(list.get(i) > num) list.add(i, num);
        else list.add(i + 1, num);
    }
    
    public double findMedian() {
        int size = list.size();
        if(size % 2 == 1) return list.get(size / 2);
        return (list.get(size / 2) + list.get(size / 2 - 1)) * 1.0 / 2;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
