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
    ListNode* get(ListNode* head, int k){
        ListNode* tmp = head;
        while(k--)
            tmp = tmp->next;
        return tmp;
    }
    
    int size(ListNode* head){
        int size = 0;
        ListNode* tmp = head;
        while(tmp != nullptr){
            size++;
            tmp = tmp->next;
        }
        return size;
    }
    
    ListNode* swapNodes(ListNode* head, int k) {
        int sz = size(head);
        ListNode* kbeg = get(head, k - 1);
        ListNode* kend = get(head, sz - k);
        swap(kbeg->val, kend->val);
        return head;
    }
};
