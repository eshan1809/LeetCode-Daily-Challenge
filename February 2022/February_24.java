/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode mid = midNode(head), second = mid.next;
        mid.next = null;
        head = sortList(head);
        second = sortList(second);
        return mergeLists(head, second);
    }
    
    private ListNode midNode(ListNode head){
        if(head == null || head.next == null)
            return head;
        ListNode s = head, f = head.next;
        while(f != null && f.next != null){
            s = s.next;
            f = f.next.next;
        }
        return s;
    }
    
    private ListNode mergeLists(ListNode h1, ListNode h2){
        ListNode t1 = h1, t2 = h2, h = new ListNode(0), t = h;
        
        while(t1 != null && t2 != null){
            if(t1.val < t2.val){
                t.next = new ListNode(t1.val);
                t1 = t1.next;
                t = t.next;
            } else{
                t.next = new ListNode(t2.val);
                t2 = t2.next;
                t = t.next;
            }
        }
        
        if(t1 != null)
            t.next = t1;
        if(t2 != null)
            t.next = t2;
        
        return h.next;
    }
}
