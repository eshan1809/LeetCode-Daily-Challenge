class MinStack {
    public class stackNode{
        int val, min;
        stackNode next;
        stackNode(int x, int y, stackNode z){
            val = x;
            min = y;
            next = z;
        }
    }
    stackNode node;
    /** initialize your data structure here. */
    public MinStack() {
        node = null;
    }
    
    public void push(int val) {
        node = new stackNode(val, (node == null) ? val : Math.min(val, node.min), node);
    }
    
    public void pop() {
        if(node != null) node = node.next;
    }
    
    public int top() {
        return node.val;
    }
    
    public int getMin() {
        return node.min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
