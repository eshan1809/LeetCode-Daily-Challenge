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
    public ListNode swapNodes(ListNode head, int k) {
        int n = size(head);
        ListNode kbeg = get(head, k - 1), kend = get(head, n - k);
        int tmp = kbeg.val;
        kbeg.val = kend.val;
        kend.val = tmp;
        return head;
    }
    
    private int size(ListNode head){
        int size = 0;
        ListNode tmp = head;
        while(tmp != null){
            size++;
            tmp = tmp.next;
        }
        return size;
    }
    
    private ListNode get(ListNode head, int k){
        ListNode tmp = head;
        while(k-- > 0)
            tmp = tmp.next;
        return tmp;
    }
}
