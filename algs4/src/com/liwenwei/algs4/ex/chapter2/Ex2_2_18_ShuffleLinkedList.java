/*****************************************************************
 * 2.2.18 打乱链表。实现一个分治算法，使用线性对数级别的时间和对数级别的额外空
 * 间随机打乱一条链表
 * 
 * Perform the same procedure as merge sort. When merging, instead of selecting an element (one-by-one)
 * from the two lists in sorted order, flip a coin. Choose whether to pick an element from the first 
 * or from the second list based on the result of the coin flip
 * 
 * 请参考：https://stackoverflow.com/questions/12167630/algorithm-for-shuffling-a-linked-list-in-n-log-n-time/12168162#12168162
 * <pre>
 * {@code
 * shuffle(list):
 *    if list contains a single element
 *        return list
 * 
 *    list1,list2 = [],[]
 *    while list not empty:
 *        move front element from list to list1
 *        if list not empty: move front element from list to list2
 * 
 *    shuffle(list1)
 *    shuffle(list2)
 * 
 *    if length(list2) < length(list1):
 *        i = pick a number uniformly at random in [0..length(list2)]             
 *        insert a dummy node into list2 at location i 
 * 
 *    # merge
 *    while list1 and list2 are not empty:
 *        if coin flip is Heads:
 *            move front element from list1 to list
 *        else:
 *            move front element from list2 to list
 * 
 *    if list1 not empty: append list1 to list
 *    if list2 not empty: append list2 to list
 * 
 *    remove the dummy node from list
 * }
 * </pre>
 * 
 * @author liwenwei
 * 
 ****************************************************************/
package com.liwenwei.algs4.ex.chapter2;

import com.liwenwei.algs4.code.Node;

// TODO: 还有些问题
public class Ex2_2_18_ShuffleLinkedList {
	
	Node head;
	Node tail;
	
	public static void main(String[] args) {
		Ex2_2_18_ShuffleLinkedList li = new Ex2_2_18_ShuffleLinkedList();
		li.push(1);
		li.push(2);
		li.push(3);
		li.push(4);
		li.push(5);
		li.push(6);
		li.push(7);
		li.push(8);
		li.push(9);
		li.push(10);
		
		li.printList(li.head);
		li.head = li.shuffle(li.head);
		li.printList(li.head);
	}
	
	public Node mergeRandom(Node head, Node headA, Node headB) {
		Node dummy = head;
		while (headA != null && headB != null) {
			if (Math.random() < 0.5) { // If coin flip is head
				head = headA;
				headA = headA.next;
			} else { // If coin flip is back
				head = headB;
				headB = headB.next;
			}
			head = head.next;
		}
		if (headA == null) {
			head.next = headB;
			return dummy;
		}
		if (headB == null) {
			head.next = headA;
			return dummy;
		}
		return dummy;
	}
	
	public Node shuffle(Node head) {
		if (head == null || head.next == null)
			return head;
		Node headA = head, headB = head.next;
		Node a = head, b = head.next;
		head = head.next.next;
		while (head != null) {
			a.next = head;
			a = a.next;
			head = head.next;
			
			if (head != null) {
				b.next = head;
				b = b.next;
				head = head.next;
			}
		}
		Node shuf1 = shuffle(headA);
		Node shuf2 = shuffle(headB);
		return mergeRandom(head, shuf1, shuf2);
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
