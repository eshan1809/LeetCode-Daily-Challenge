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
    void reverse(ListNode* start, ListNode* end){
        if(start == nullptr || start->next == nullptr)
            return;
        ListNode *tmp = start, *prev = nullptr, *nxt = nullptr;
        while(tmp != end){
            nxt = tmp->next;
            tmp->next = prev;
            prev = tmp;
            tmp = nxt;
        }
        tmp->next = prev;
    }
    
    ListNode* reverseBetween(ListNode* head, int left, int right) {
        ListNode *f1 = nullptr, *f2 = head, *s1 = head, *s2 = nullptr;
        while(s1 != nullptr){
            if(left > 1){
                left--;
                f1 = f2;
                f2 = f2->next;
            }
            if(right > 1){
                right--;
                s1 = s1->next;
            }
            if(right == 1){
                s2 = s1->next;
                break;
            }
        }
        reverse(f2, s1);
        f2->next = s2;
        if(f1 != nullptr){
            f1->next = s1;
            return head;
        }
        return s1;
    }
};
