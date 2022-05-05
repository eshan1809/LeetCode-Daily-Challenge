class MyStack {
    Queue<Integer> q, tmp;

    public MyStack() {
        q = new ArrayDeque<>();
        tmp = new ArrayDeque<>();
    }
    
    public void push(int x) {
        q.add(x);
    }
    
    public int pop() {
        while(q.size() > 1)
            tmp.add(q.remove());
        int ans = q.remove();
        while(!tmp.isEmpty())
            q.add(tmp.remove());
        return ans;
    }
    
    public int top() {
        while(q.size() > 1)
            tmp.add(q.remove());
        int ans = q.peek();
        tmp.add(q.remove());
        while(!tmp.isEmpty())
            q.add(tmp.remove());
        return ans;
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
