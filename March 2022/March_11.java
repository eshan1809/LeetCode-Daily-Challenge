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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null)
            return head;
        int size = size(head);
        k %= size;
        if(k == 0)
            return head;
        k = size - k - 1;
        ListNode tmp = head;
        while(k > 0){
            k--;
            tmp = tmp.next;
        }
        ListNode ans = tmp.next;
        tmp.next = null;
        tmp = ans;
        while(tmp.next != null)
            tmp = tmp.next;
        tmp.next = head;
        return ans;
    }
    
    private int size(ListNode head){
        ListNode tmp = head;
        int size = 0;
        while(tmp != null){
            tmp = tmp.next;
            size++;
        }
        return size;
    }
}
