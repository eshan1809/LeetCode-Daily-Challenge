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
    public boolean isPalindrome(ListNode head) {
        int n = 0;
        ListNode tmp = head, prev = null;
        while(tmp != null){
            tmp = tmp.next;
            n++;
        }
        if(n == 1)
            return true;
        if(n == 2)
            return head.val == head.next.val;
        tmp = head;
        n -= n / 2;
        while(n-- > 0){
            prev = tmp;
            tmp = tmp.next;
        }
        prev.next = null;
        while(tmp != null){
            ListNode nxt = tmp.next;
            tmp.next = prev;
            prev = tmp;
            tmp = nxt;
        }
        while(prev != null && head != null){
            if(prev.val != head.val)
                return false;
            prev = prev.next;
            head = head.next;
        }
        return true;
    }
}
