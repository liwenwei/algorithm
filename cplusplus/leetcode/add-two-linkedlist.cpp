
/**
* Definition for singly-linked list.
*/

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(nullptr) {}
};

/*
* input: (2->4->3)+(5->6->4)
* output: 7->0->8
*/
ListNode* addTwoNumbers(ListNode* l1, ListNode* l2)
{
    ListNode* result = new ListNode(0);
    ListNode* tail = result;
    ListNode* curr1 = l1;
    ListNode* curr2 = l2;
    int carry = 0;
    int value;
    while (curr1 && curr2)
    {
        int temp = curr1->val + curr2->val + carry;
        carry = temp / 10;
        value = temp % 10;
        tail->next = new ListNode(value);
        tail = tail->next;
        curr1 = curr1->next;
        curr2 = curr2->next;
    }

    ListNode* extra = curr1 ? curr1 : curr2;
    while (extra)
    {
        int temp = extra->val + carry;
        carry = temp / 10;
        value = temp % 10;
        tail->next = new ListNode(value);
        tail = tail->next;
        extra = extra->next;
    }

    if (carry != 0)
    {
        tail->next = new ListNode(carry);
    }

    return result->next;
}