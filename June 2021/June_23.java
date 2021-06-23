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
    
    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode prev = null;
        while (head.next != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        head.next = prev;
        return head;
    }
    
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode first, mid, end, t1 = head, t2;
        int i = 2;
        if (left == 1) {
            first = null;
            mid = head;
            t2 = head;
        } else {
            first = head;
            while (i < left) {
                t1 = t1.next;
                i++;
            }
            i++;
            mid = t1.next;
            t1.next = null;
            t2 = mid;
        }
        while (i <= right) {
            t2 = t2.next;
            i++;
        }
        end = t2.next;
        t2.next = null;
        t2 = reverse(mid);
        if (first == null) {
            mid.next = end;
            return t2;
        } else {
            t1.next = t2;
            mid.next = end;
            return first;
        }
    }
}
