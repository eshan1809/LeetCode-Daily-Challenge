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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode list = null, t = null, t1 = list1, t2 = list2;
        while(t1 != null && t2 != null){
            if(t1.val < t2.val){
                if(list == null)
                    t = list = t1;
                else
                    t = t.next = t1;
                t1 = t1.next;
            } else{
                if(list == null)
                    t = list = t2;
                else
                    t = t.next = t2;
                t2 = t2.next;
            }
        }
        if(t1 != null){
            if(list == null)
                list = t1;
            else
                t.next = t1;
        }            
        if(t2 != null){
            if(list == null)
                list = t2;
            else
                t.next = t2;
        }
        return list;
    }
}
