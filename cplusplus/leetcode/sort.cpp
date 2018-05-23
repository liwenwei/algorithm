#include <Windows.h>

using namespace std;


// Definition for singly-linked list.
struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

ListNode* insertionSortList(ListNode* head) {
    if (!head)return NULL;

    ListNode* dummy = new ListNode(0); // new start of the sorted list
    ListNode* cur = head;              
    ListNode* pre = dummy;             // insert node between pre and pre.next
    ListNode* next = NULL;
    while (cur)
    {
        next = cur->next;
        while (pre->next != NULL && pre->next->val < cur->val)
            pre = pre->next;
        cur->next = pre->next;
        pre->next = cur;
        pre = dummy;
        cur = next;
    }

    return dummy->next;
}
