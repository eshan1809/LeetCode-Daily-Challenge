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

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    
    Random rand;
    ListNode head;
    int size = 0;
    
    private int size(ListNode head){
        if(head == null)
            return 0;
        return 1 + size(head.next);
    }
    
    public Solution(ListNode head) {
        rand = new Random();
        this.head = head;
        this.size = size(head);
    }
    
    private int get(ListNode node, int n){
        if(n == 0)
            return node.val;
        return get(node.next, n - 1);
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        return get(head, rand.nextInt(this.size));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
