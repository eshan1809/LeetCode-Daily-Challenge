// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> itr;
    Integer curr;
    
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    itr = iterator;
        if(itr.hasNext())
	        curr = itr.next();
        else
            curr = null;
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return curr;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
        Integer ans = curr;
        if(itr.hasNext())
	        curr = itr.next();
        else
            curr = null;
        return ans;
	}
	
	@Override
	public boolean hasNext() {
	    return curr != null;
	}
}
