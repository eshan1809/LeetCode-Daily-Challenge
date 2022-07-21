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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode f1 = null, f2 = head, s1 = head, s2 = null;
        while(s1 != null){
            if(left > 1){
                left--;
                f1 = f2;
                f2 = f2.next;
            }
            if(right > 1){
                right--;
                s1 = s1.next;
            }
            if(right == 1){
                s2 = s1.next;
                break;
            }
        }
        reverse(f2, s1);
        f2.next = s2;
        if(f1 != null){
            f1.next = s1;
            return head;
        }
        return s1;
    }
    
    private void reverse(ListNode start, ListNode end){
        if(start == null || start.next == null)
            return;
        ListNode tmp = start, prev = null, nxt = null;
        while(tmp != end){
            nxt = tmp.next;
            tmp.next = prev;
            prev = tmp;
            tmp = nxt;
        }
        tmp.next = prev;
    }
}
