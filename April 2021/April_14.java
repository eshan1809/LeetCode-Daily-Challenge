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
    public ListNode partition(ListNode head, int x) {
        ListNode list = new ListNode(), tempx = new ListNode();
        ListNode temp1 = list, temp2 = tempx;
        while(head != null){
            if(head.val < x){
                temp1.next = head;
                temp1 = temp1.next;
            } else{
                temp2.next = head;
                temp2 = temp2.next;
            }
            head = head.next;
        }
        temp1.next = tempx.next;
        temp2.next = null;
        return list.next;
    }
}
