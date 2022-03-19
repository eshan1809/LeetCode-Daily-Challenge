class FreqStack {
    class Pair implements Comparable<Pair>{
        int val, freq, time;
        Pair(int val, int freq, int time){
            this.val = val;
            this.freq = freq;
            this.time = time;
        }
        public int compareTo(Pair o){
            if(this.freq != o.freq)
                return o.freq - this.freq;
            return o.time - this.time;
        }
    }
    
    PriorityQueue<Pair> pq;
    Map<Integer, Integer> map;
    int time;
    
    public FreqStack() {
        pq = new PriorityQueue<>();
        map = new HashMap<>();
        time = 0;
    }
    
    public void push(int val) {
        int freq = map.getOrDefault(val, 0);
        map.put(val, freq + 1);
        pq.add(new Pair(val, freq + 1, time++));
    }
    
    public int pop() {
        Pair ret = pq.remove();
        if(map.get(ret.val) == 1)
            map.remove(ret.val);
        else
            map.put(ret.val, map.get(ret.val) - 1);
        return ret.val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
