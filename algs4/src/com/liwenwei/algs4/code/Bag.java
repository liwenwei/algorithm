package com.liwenwei.algs4.code;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Bag<E> implements Iterable<E> {

	private Node<E> head;
	private int N = 0;
	
	// Linked list class
	private class Node<E> {
		private E item;
		private Node<E> next;
	}
	
	public Bag() {
		head = null;
	}
	
	// add node to head
	public void add(E item) {
		Node<E> old = head;
		head = new Node<E>();
		head.item = item;
		head.next = old;
		N++;
	}
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	public int size() {
		return N;
	}
	
	@Override
	public Iterator<E> iterator() {
		return new BagIterator<E>(head);
	}
	
	public class BagIterator<E> implements Iterator<E> {

		private Node<E> node;
		
		public BagIterator(Node<E> node) {
			this.node = node;
		}
		
		@Override
		public boolean hasNext() {
			return node.next != null;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
		
		@Override
		public E next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			};
			E item = node.item;
			node = node.next;
			return item;
		}
		
	}
}
