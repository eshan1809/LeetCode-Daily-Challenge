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
    ListNode* partition(ListNode* head, int x) {
        ListNode *s = nullptr, *g = nullptr, *st = nullptr, *gt = nullptr, *t = head;
        while(t != nullptr){
            if(t->val < x){
                if(s == nullptr)
                    st = s = t;
                else{
                    st->next = t;
                    st = st->next;
                }
            } else{
                if(g == nullptr)
                    gt = g = t;
                else{
                    gt->next = t;
                    gt = gt->next;
                }
            }
            t = t->next;
        }
        if(s == nullptr)
            return g;
        st->next = g;
        if(g != nullptr)
            gt->next = nullptr;
        return s;
    }
};
