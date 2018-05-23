#include <iostream>

using namespace std;

typedef struct _LinkNode
{
    int value;
    _LinkNode *next;
} LinkNode;


LinkNode* magic(int CardNumber)
{
    LinkNode *head = NULL;
    LinkNode *prev = NULL;
    LinkNode *curr = NULL;

    head = (LinkNode *)malloc(sizeof(LinkNode));
    head->value = 1;
    prev = head;

    for (int i = 2; i < CardNumber; i++)
    {
        LinkNode *curr = (LinkNode *)malloc(sizeof(LinkNode));
        curr->value = i;
        prev->next = curr;
        prev = curr;
    }

    curr->next = head;

    curr = head;
    for (int i = 1; i <= CardNumber; i++)
    {
        for (int j = 1; j <= i; j++)
        {
            curr = curr->next;
        }

        curr->value = i;
    }

    return curr;
}