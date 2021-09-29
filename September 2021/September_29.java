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
    public int size(ListNode root){
        ListNode temp = root;
        int size = 0;
        while(temp != null){
            temp = temp.next;
            size++;
        }
        return size;
    }
    public ListNode[] splitListToParts(ListNode root, int k) {
        int size = size(root), group = size / k, rem = size % k;
        ListNode[] ans = new ListNode[k];
        ListNode temp = root;
        for(int i = 0; i < k; i++){
            ListNode head = new ListNode(0), nhead = head;
            for(int j = 0; j < group + (i < rem ? 1 : 0); j++){
                nhead.next = new ListNode(temp.val);
                nhead = nhead.next;
                if(temp != null) temp = temp.next;
            }
            ans[i] = head.next;
        }
        return ans;
    }
}
