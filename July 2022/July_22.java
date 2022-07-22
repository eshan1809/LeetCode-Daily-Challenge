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
        ListNode smaller = null, greater = null, st = null, gt = null, tmp = head;
        while(tmp != null){
            if(tmp.val < x){
                if(smaller == null)
                    st = smaller = tmp;
                else{
                    st.next = tmp;
                    st = st.next;
                }
            } else{
                if(greater == null)
                    gt = greater = tmp;
                else{
                    gt.next = tmp;
                    gt = gt.next;
                }
            }
            tmp = tmp.next;
        }
        if(smaller == null)
            return greater;
        st.next = greater;
        if(greater != null)
            gt.next = null;
        return smaller;
    }
}
