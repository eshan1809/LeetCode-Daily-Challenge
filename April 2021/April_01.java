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
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList();
        fillList(list, head);
        for(int i=0; i<list.size()/2; i++) if(list.get(i) != list.get(list.size()-i-1)) return false;
        return true;
    }
    public void fillList(List<Integer> list, ListNode temp){
        if(temp == null) return;
        list.add(temp.val);
        fillList(list, temp.next);
    }
}
