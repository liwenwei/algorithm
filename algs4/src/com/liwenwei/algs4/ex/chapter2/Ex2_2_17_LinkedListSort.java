/*****************************************************************
 * 2.2.17 链表排序。实现对链表的自然排序
 * （这是将链表排序的最佳方法，因为它不需要额外的空间，且运行时间是线性对数级别的）
 * 
 * @author liwenwei
 * 
 ****************************************************************/
package com.liwenwei.algs4.ex.chapter2;

import com.liwenwei.algs4.code.Node;

public class Ex2_2_17_LinkedListSort {

	Node head;
	Node tail;

	public static void main(String[] args) {
		Ex2_2_17_LinkedListSort li = new Ex2_2_17_LinkedListSort();
		li.push(6);
		li.push(4);
		li.push(10);
		li.push(7);
		li.push(7);
		li.push(1);
		li.push(8);
		li.push(10);
		li.push(8);
		li.push(9);
		li.push(10);
		
		li.printList(li.head);
		li.head = li.sort(li.head);
		li.printList(li.head); 
	}

	public Node sort(Node h) {
		if (h == null || h.next == null)
			return h;

		Node mid = getMid(h);
		Node mid_next = mid.next;
		mid.next = null;
		Node left = sort(h);
		Node right = sort(mid_next);
		return sortedMerge(left, right);
	}

	private Node sortedMerge(Node a, Node b) {
		Node result = null;
		if (a == null) {
			return b;
		}
		if (b == null) {
			return a;
		}

		if (a.value <= b.value) {
			result = a;
			result.next = sortedMerge(a.next, b);
		} else {
			result = b;
			result.next = sortedMerge(a, b.next);
		}
		return result;
	}

	private Node getMid(Node h) {
		if (h == null)
			return h;
		Node fastptr = h.next;
		Node slowptr = h;
		// Move the slow and fast pointer
		while (fastptr != null) {
			fastptr = fastptr.next;
			if (fastptr != null) {
				fastptr = fastptr.next;
				slowptr = slowptr.next;
			}
		}
		return slowptr;
	}

	private void push(int val) {
		if (head == null) {
			head = new Node(val);
			tail = head;
		} else {
			tail.next = new Node(val);
			tail = tail.next;
		}
	}

	public void printList(Node h) {
		while (h != null) {
			System.out.print(h.value + " ");
			h = h.next;
		}
		System.out.println();
	}
}
