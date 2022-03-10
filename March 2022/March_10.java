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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int val = (l1.val + l2.val) % 10, carry = (l1.val + l2.val) / 10;
        ListNode head = new ListNode(val), tmp = head;
        l1 = l1.next;
        l2 = l2.next;
        while(l1 != null && l2 != null){
            val = (l1.val + l2.val + carry) % 10;
            carry = (l1.val + l2.val + carry) / 10;
            tmp.next = new ListNode(val);
            tmp = tmp.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        
        while(l1 != null){
            val = (l1.val + carry) % 10;
            carry = (l1.val + carry) / 10;
            tmp.next = new ListNode(val);
            tmp = tmp.next;
            l1 = l1.next;
        }
        
        while(l2 != null){
            val = (l2.val + carry) % 10;
            carry = (l2.val + carry) / 10;
            tmp.next = new ListNode(val);
            tmp = tmp.next;
            l2 = l2.next;
        }
        
        if(carry > 0)
            tmp.next = new ListNode(carry);
        
        return head;
    }
}
