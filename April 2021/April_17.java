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
    public int size(ListNode head){
        if(head == null) return 0;
        return 1 + size(head.next);
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int x = size(head) - n;
        if(x < 0) return head;
        if(x == 0) return head.next;
        ListNode temp = head;
        while(x-- > 1){
            temp = temp.next;
        }
        if(temp.next == null) return head;
        if(temp.next.next == null) temp.next = null;
        else temp.next = temp.next.next;
        return head;
    }
}
