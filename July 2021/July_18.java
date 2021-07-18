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
    static ListNode th = null, tt = null;

    public static void addFirst(ListNode node) {
        if (th == null){
            th = node;
            tt = node;
        } else{
            node.next = th;
            th = node;
        }
    }

    public static int size(ListNode head){
        int size = 0;
        ListNode temp = head;
        while(temp != null){
            temp = temp.next;
            size++;
        }
        return size;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode oh = null, ot = null, curr = head;
        int s = size(head);
        if(s < k || k == 0) return head;
        while(s >= k){
            int i = k;
            while(i-- > 0){
                ListNode f = curr.next;
                addFirst(curr);
                curr = f;
            }
            if(oh == null){
                oh = th;
                ot = tt;
            } else{
                ot.next = th;
                ot = tt;
            }
            th = tt = null;
            s -= k;
        }
        ot.next = curr;
        return oh;
    }
}
