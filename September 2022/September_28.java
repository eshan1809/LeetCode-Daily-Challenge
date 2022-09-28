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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int rem = size(head) - n;
        if(rem == 0)
            return head.next;
        ListNode tmp = head;
        while(rem-- > 1)
            tmp = tmp.next;
        tmp.next = tmp.next.next;
        return head;
    }
    
    private int size(ListNode head){
        int size = 0;
        ListNode tmp = head;
        while(tmp != null){
            tmp = tmp.next;
            size++;
        }
        return size;
    }
}
