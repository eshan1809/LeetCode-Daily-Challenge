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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)
            return null;
        ListNode list = head, prev = null, curr = head, tmp = head.next;
        while(curr != null){
            while(tmp != null && tmp.val == curr.val)
                tmp = tmp.next;
            
            if(tmp == curr.next){
                prev = curr;
                curr = curr.next;
            } else{
                if(prev == null)
                    list = tmp;
                else
                    prev.next = tmp;
                curr = tmp;
            }
            
            if(curr != null && (curr.next == null || curr.val != curr.next.val))
                prev = curr;
        }
        return list;
    }
}
