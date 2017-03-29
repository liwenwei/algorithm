/*
* Remove Linked List Elements, remove all elements from a linked list of integers that have value val.
*/
ListNode* removeElements(ListNode* head, int val) {
    if (head == NULL) return NULL;
    head->next = removeElements(head->next, val);
    return head->val == val ? head->next : head;
}

ListNode* removeElements1(ListNode* head, int val)
{
    ListNode* fakeHead = new ListNode(-1);
    fakeHead->next = head;
    ListNode* curr = fakeHead;
    while (curr)
    {
        if (curr->next && curr->next->val == val)
        {
            curr->next = curr->next->next;
        }
        else
        {
            curr = curr->next;
        }
    }
    return fakeHead->next;
}

int main()
{
    ListNode first(1);
    ListNode second(2);
    ListNode third(3);
    ListNode forth(4);

    first.next = &second;
    second.next = &third;
    third.next = &forth;

    ListNode* result = swapPairs(&first);
    ListNode* result1 = removeElements(&first, 5);
}