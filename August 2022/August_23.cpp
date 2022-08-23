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
    bool isPalindrome(ListNode* head) {
        int n = 0;
        ListNode *tmp = head, *prev = nullptr;
        while(tmp != nullptr){
            tmp = tmp->next;
            n++;
        }
        if(n == 1)
            return true;
        if(n == 2)
            return head->val == head->next->val;
        tmp = head;
        n -= n / 2;
        while(n-- > 0){
            prev = tmp;
            tmp = tmp->next;
        }
        prev->next = nullptr;
        while(tmp != nullptr){
            ListNode *nxt = tmp->next;
            tmp->next = prev;
            prev = tmp;
            tmp = nxt;
        }
        while(prev != nullptr && head != nullptr){
            if(prev->val != head->val)
                return false;
            prev = prev->next;
            head = head->next;
        }
        return true;
    }
};
