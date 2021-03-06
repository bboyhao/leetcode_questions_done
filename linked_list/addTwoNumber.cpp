/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode *head = new ListNode(0);
        ListNode *cur = head;
        int temp = 0;
        int c=0;
        while(l1 || l2 || (c!=0)){
            temp = (l1?l1->val:0) + (l2?l2->val:0) + c;
            cur->next = new ListNode(temp%10);
            c=temp/10;
            cur = cur -> next;
            if(l1)l1=l1->next;
            if(l2)l2=l2->next;
        }
        return head->next;
    }
};