/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null)
            return false;
        ListNode s = head, f = head.next;
        while(s != null && f != null){
            if(s == f)
                return true;
            s = s.next;
            if(f.next != null)
                f = f.next.next;
            else
                break;
        }
        return false;
    }
}
