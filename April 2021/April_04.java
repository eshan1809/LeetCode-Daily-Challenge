class MyCircularQueue {
    
    int[] arr;
    int size, count = 0, front = -1, rear = -1;

    public MyCircularQueue(int k) {
        this.size = k;
        arr = new int[k];
    }
    
    public boolean enQueue(int value) {
        if(count == size) return false;
        rear = (++rear % size);
        count++;
        arr[rear] = value;
        return true;
    }
    
    public boolean deQueue() {
        if(count == 0) return false;
        count--;
        front = (++front % size);
        return true;        
    }
    
    public int Front() {
        if(count != 0) return arr[(front + 1) % size];
        return -1;
    }
    
    public int Rear() {
        if(count != 0) return arr[rear];
        return -1;
    }
    
    public boolean isEmpty() {
        return count == 0;
    }
    
    public boolean isFull() {
        return count == size;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
