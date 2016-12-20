#include <iostream>

using namespace std;

struct ListNode
{
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(nullptr){}
};

/*
* Delete Node in a Linked List
*/
void deleteNode(ListNode* node)
{
    ListNode* next = node->next;
    *node = *next;
    delete next;
}

/*
* Reverse a singly linked list
*/
ListNode* reserveList1(ListNode* head)
{
    ListNode* prev = NULL;
    while (head)
    {
        ListNode* next = head->next;
        head->next = prev;
        prev = head;
        head = next;
    }
    return prev;
}

ListNode* reserveList(ListNode* head)
{
    ListNode* new_head = NULL;
    ListNode* curr = head;
    ListNode* temp = NULL;
    while (curr)
    {
        temp = new_head;
        new_head = curr;
        curr = curr->next;
        new_head->next = temp;
    }
    return new_head;
}

bool hasCycle(ListNode *head)
{
    if (head == NULL || head->next == NULL) return false;
    ListNode *pSlow = head;
    ListNode *pFast = head->next;
    while (pSlow != pFast)
    {
        if (pFast == NULL || pFast->next == NULL) return false;
        pSlow = pSlow->next;
        pFast = pFast->next->next;
    }

    return true;
}

ListNode* swapPairs(ListNode* head)
{
    if (head == NULL) return NULL;
    if (head->next == NULL) return NULL;

    int temp = 0;
    ListNode *node = head;

    while (node->next != NULL)
    {
        temp = node->val;
        node->val = node->next->val;
        node->next->val = temp;
        node = node->next;
    }

    return head;
}