/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if(head == null)
            return null;
        Node temp = head;
        while(temp != null){
            if(temp.child != null){
                Node child = flatten(temp.child), t = child, b = temp.next;
                while(t.next != null)
                    t = t.next;
                temp.child = null;
                temp.next = child;
                child.prev = temp;
                t.next = b;
                if(b != null)
                    b.prev = t;
                temp = b;
            } else
                temp = temp.next;
        }
        return head;
    }
}
