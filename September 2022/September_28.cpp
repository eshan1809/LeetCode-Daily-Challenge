/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    int size(ListNode* head){
        int size = 0;
        ListNode *tmp = head;
        while(tmp != nullptr){
            tmp = tmp->next;
            size++;
        }
        return size;
    }
    
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        int rem = size(head) - n;
        if(rem == 0)
            return head->next;
        ListNode *tmp = head;
        while(rem-- > 1)
            tmp = tmp->next;
        tmp->next = tmp->next->next;
        return head;
    }
};
