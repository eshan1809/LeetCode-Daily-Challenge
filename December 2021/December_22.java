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
    public static ListNode midNode(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    public static ListNode reverse(ListNode head){
        if(head == null || head.next == null)
            return head;
        ListNode prev = null;
        while(head.next != null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        head.next = prev;
        return head;
    }
    
    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null)
            return;
        ListNode mid = midNode(head), nhead = mid.next;
        mid.next = null;
        nhead = reverse(nhead);
        ListNode t1 = head, t2 = nhead;
        while(t2 != null){
            ListNode b1 = t1.next, b2 = t2.next;
            t1.next = t2;
            t2.next = b1;
            t1 = b1;
            t2 = b2;
        }
    }
}
