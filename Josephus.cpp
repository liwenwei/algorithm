#include <iostream>

using namespace std;

typedef struct _LinkNode
{
    int value;
    _LinkNode *next;
} LinkNode;

/*
* 创建循环链表
* @n int, 链表长度
*/
LinkNode* createCycle(int n)
{
    int index = 1;
    LinkNode *head = NULL;
    LinkNode *prev = NULL;
    LinkNode *curr = NULL;

    head = (LinkNode *)malloc(sizeof(LinkNode));
    head->value = index;
    prev = head;

    while (index++ < n)
    {
        curr = (LinkNode *)malloc(sizeof(LinkNode));
        curr->value = index;
        prev->next = curr;
        prev = curr;
    }

    curr->next = head;

    return head;
}

/*
* 打印循环链表
* @**node LinkNode
*/
void displayCycle(LinkNode **head)
{
    LinkNode *node = *head;

    while (node->next != (*head))
    {
        printf("%d ", node->value);
        node = node->next;
    }

    printf("\n");
}

/*
* 解决约瑟夫问题，输出自杀序列，直到所有人都被杀死为止。
* @**head LinkNode
* @m int, 从第一个开始报数，第M个将被杀掉
*/
void josephus(LinkNode **head, int m)
{
    LinkNode *prev = *head;
    LinkNode *curr = *head;

    while (true)
    {
        for (int i = 0; i < m - 1; i++)
        {
            prev = curr;
            curr = curr->next;
        }

        if (prev->next == curr->next)
        {
            printf("%d has been killed.\n", curr->value);
            free(curr);
            break;
        }

        prev->next = curr->next;
        printf("%d has been killed.\n", curr->value);
        free(curr);
        curr = prev->next;
    }
}


int main()
{
    LinkNode *node = createCycle(41);
    displayCycle(&node);
    josephus(&node, 3);
}
