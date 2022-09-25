class MyCircularQueue {
public:
    int arr[1000];
    int size, count = 0, front = -1, rear = -1;
    
    MyCircularQueue(int k) {
        size = k;
    }
    
    bool enQueue(int value) {
        if(count == size)
            return false;
        rear++;
        rear %= size;
        count++;
        arr[rear] = value;
        return true;
    }
    
    bool deQueue() {
        if(count == 0)
            return false;
        count--;
        front++;
        front %= size;
        return true; 
    }
    
    int Front() {
        if(count != 0)
            return arr[(front + 1) % size];
        return -1;
    }
    
    int Rear() {
        if(count != 0)
            return arr[rear];
        return -1;
    }
    
    bool isEmpty() {
        return count == 0;
    }
    
    bool isFull() {
        return count == size;
    }
};

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue* obj = new MyCircularQueue(k);
 * bool param_1 = obj->enQueue(value);
 * bool param_2 = obj->deQueue();
 * int param_3 = obj->Front();
 * int param_4 = obj->Rear();
 * bool param_5 = obj->isEmpty();
 * bool param_6 = obj->isFull();
 */
