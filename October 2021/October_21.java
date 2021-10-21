class RandomizedSet {
    HashMap<Integer, Integer> map;
    int[] indices;
    int last = 0;
    Random random;

    /** Initialize your data structure here. */
    public RandomizedSet(){
        map = new HashMap();
        indices = new int[100000];
        random = new Random();
    }
    
    // Update HashMap value with last index. -1 means this value is deleted.
    public boolean insert(int val){
        Integer index = map.get(val);
        if(index != null && index != -1)
            return false;
        map.put(val, last);
        indices[last++] = val;
        return true;
    }
    
    // Update index of deleted value to -1
    public boolean remove(int val){
        Integer index = map.get(val);
        if(index == null || index == -1)
            return false;
        map.put(val, -1);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int result = -1;
        int index = -1;
        while (index == -1) {
            result = indices[random.nextInt(last)];
            index = map.get(result);
        } 
        return result;
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
