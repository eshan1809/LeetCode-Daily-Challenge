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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(0), tmp = head;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for(int i = 0; i < lists.length; i++)
            if(lists[i] != null)
                pq.add(lists[i]);
        while(!pq.isEmpty()){
            ListNode rem = pq.remove();
            tmp.next = rem;
            tmp = tmp.next;
            if(rem.next != null)
                pq.add(rem.next);
        }
        tmp.next = null;
        return head.next;
    }
}
