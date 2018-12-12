package com.liwenwei.algs4.code;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Queue<E> implements Iterable<E> {

	private Node<E> head;
	private Node<E> tail;
	private int N = 0;
	
	// Linked list class
	private class Node<E> {
		private E item;
		private Node<E> next;
	}

	public Queue() {
		head = null;
		tail = null;
	}
	
	public void enqueue(E item) {
		Node<E> node = new Node<E>();
		node.item = item;
		if (head == null) {
			head = node;
			tail = node;
		} else {
			tail.next = node;
			tail = node;
		}
		
		N++;
	}
	
	public E dequeue() {
		Node<E> oldHead= head;
		E item = oldHead.item;
		head = head.next;
		N--;
		return item;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public int size() {
		return N;
	} 
	
	@Override
	public Iterator<E> iterator() {
		return new QueueIterator<E>(head);
	}
	
	public class QueueIterator<E> implements Iterator<E> {
		
		private Node<E> node;
		
		public QueueIterator(Node<E> node) {
			this.node = node;
		}
		
		@Override
		public boolean hasNext() {
			return node != null;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
		
		@Override
		public E next() {
			E item = null;
			if (node != null) {
				item = node.item;
				node = node.next;
			}
			return item;
		}
	}
	
	public static void main(String[] args) {
		Queue<Integer> q = new Queue<Integer>();
		
		while (!StdIn.isEmpty()) {
			q.enqueue(StdIn.readInt());
		}
		
		int N = q.size();
		int[] a = new int[N];
		for (int i = 0; i < N; i++) {
			a[i] = q.dequeue();
		}
		
		StdOut.print(Arrays.toString(a));
	}

}
