/*****************************************************************
 * 归并两个有序链表
 * 
 * @author liwenwei
 * 
 ****************************************************************/
package com.liwenwei.algs4.code;

public class SortLinkedList {

	public static void main(String[] args) {
		Node headA = new Node(1);
		Node node1 = new Node(3);
		Node node2 = new Node(5);
		headA.next = node1;
		node1.next = node2;
		node2.next = new Node(9);
		
		Node headB = new Node(2);
		Node node3 = new Node(4);
		Node node4 = new Node(6);
		headB.next = node3;
		node3.next = node4;
		
		print(headA);
		print(headB);
		//Node mergedNode = sortedMerge(headA, headB);
		Node mergedNode = sortedMergeII(headA, headB);
		print(mergedNode);
	}
	
	/**
	 * 合并两个有序的链表，一种基本的实现沿用的是{@code com.liwenwei.algs4.Merge}的思想
	 * @param headA Linked List A
	 * @param headB Linked List B
	 * @return 合并后的链表
	 */
	public static Node sortedMerge(Node headA, Node headB) {
		Node head;
		// 比较headA和headB的value，取value小的node作为head，
		// 然后将 扫描指针指向head->next
		if (headA.value < headB.value) {
			head = headA;
			headA = headA.next;
		} else {
			head = headB;
			headB = headB.next;
		}
		Node tail = head;
		// 具体的合并算法沿用的归并排序里面的合并算法
		while (headA != null || headB != null) {
			if (headA == null) {
				tail.next = headB;
				headB = headB.next;
			} else if (headB == null) {
				tail.next = headA;
				headA = headA.next;
			} else if (headA.value > headB.value) {
				tail.next = headB;
				headB = headB.next;
			} else {
				tail.next = headA;
				headA = headA.next;
			}
			tail = tail.next;
		}
		return head;
	}
	
	/**
	 * 对{@code com.liwenwei.algs4.code.SortLinkedList#sortedMerge(Node, Node)}做了一些优化<br />
	 * - 创建一个dummy node，这样就不需要判断两个head的value，直接合并两个链表<br />
	 * - 根据链表结构的特许性，当headA的node取完时，直接将tail->next指向headB，省略了挨个取headB的node
	 * @param headA Linked List A
	 * @param headB Linked List B
	 * @return 合并后的链表
	 */
	public static Node sortedMergeII(Node headA, Node headB) {
		// A dummy first node
		Node dummyNode = new Node(0);
		Node tail = dummyNode;
		while (true) {
			// 因为是有序的链表，当headA的node取完时，就取headB的node，由于链表数据结构的特性，
			// 我们可以直接把tail->next指向headB，而省略了挨个取headB的node
			if (headA == null) {
				tail.next = headB;
				break;
			}
			// 当headB为null时，把tail->next指向headA
			if (headB == null) {
				tail.next = headA;
				break;
			}
			
			if (headA.value < headB.value) {
				tail.next = headA;
				headA = headA.next;
			} else {
				tail.next = headB;
				headB = headB.next;
			}
			tail = tail.next;
		}
		return dummyNode.next;
	} 
	
	public static void print(Node head) {
		Node node = head;
		while (node != null) {
			System.out.print(node.value + " ");
			node = node.next;
		}
		System.out.println();
	}
}
