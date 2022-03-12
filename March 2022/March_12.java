/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null)
            return head;
        Node nhead = new Node(head.val), t = head.next, nt = nhead;
        while(t != null){
            nt.next = new Node(t.val);
            nt = nt.next;
            t = t.next;
        }
        t = head;
        nt = nhead;
        while(t != null){
            Node tmp = nhead, th = head;
            while(th != t.random){
                tmp = tmp.next;
                th = th.next;
            }
            nt.random = tmp;
            t = t.next;
            nt = nt.next;
        }
        return nhead;
    }
}
