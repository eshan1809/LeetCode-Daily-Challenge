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
    public ListNode insertionSortList(ListNode head) {
        ListNode temp = head;
        while(temp != null && temp.next != null){
            ListNode backup = temp.next.next;
            if(temp.next.val < temp.val){
                if(temp.next.val < head.val){
                    temp.next.next = head;
                    head = temp.next;
                } else{
                    ListNode t = head;
                    while(t.next.val < temp.next.val)
                        t = t.next;
                    temp.next.next = t.next;
                    t.next = temp.next;
                }
                temp.next = backup;
            } else
                temp = temp.next;
        }
        return head;
    }
}
