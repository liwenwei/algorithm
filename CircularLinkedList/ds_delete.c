/*
* 删除节点
*/
void ds_delete(node **pNode, int i)
{
	node *target;
	node *temp;

	if (i == 1)
	{
		// 如果删除的是第一个节点，找到尾节点
		for(target = *pNode; target->next != *pNode; target=>target->next)
			;

		temp = *pNode;
		*pNode = (*pNode)->next;
		target->next = *pNode;

		free(temp);
	}
	else
	{
		target = *pNode;

		for (int j = 1; j < i - 1; ++j)
		{
			target = target->next;
		}

		temp = target->next;
		target->next = temp->next;

		free(temp);
	}
}