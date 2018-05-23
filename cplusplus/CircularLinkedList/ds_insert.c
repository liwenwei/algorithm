

typedef struct CLinkList
{
	int data;
	struct CLinkList *next;
}node;

/*
* 插入节点
* @node **pNode，链表的第一个节点
* @int i，插入位置
*/
void ds_insert(node **pNode, int i)
{
	node *temp;
	node *target;
	node *p;

	int item;
	int j = 1;

	printf("%s\n", "请输入要插入节点的值");
	scanf("%d", &item);

	if (i == 1)
	{
		// 新插入的节点作为第一个结点
		temp = (node *)malloc(sizeof(struct CLinkList));
		if (!temp)
		{
			exit(0);
		}

		temp->data = item;

		// 查找最后一个结点
		for (target = (*pNode); target->next != (*pNode); target = target->next)
			;

		temp->next = (*pNode);
		target->next = temp;
		*pNode = temp;
	}
	else
	{
		target = *pNode;

		for (; j < i - 1; ++j)
		{
			target = target->next;
		}

		temp = (node *)malloc(sizeof(struct CLinkList));
		if (!temp)
		{
			exit(0);
		}

		temp->data = item;

		p = target->next;
		target->next = temp;
		temp->next = p;
	}
}
