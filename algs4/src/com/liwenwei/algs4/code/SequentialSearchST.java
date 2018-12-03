/************************************************************************************
 * 
 * 顺序查找，基于无序链表
 * 
 ***********************************************************************************/
package com.liwenwei.algs4.code;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class SequentialSearchST<Key, Value> {

	/**
	 * Linked List
	 *
	 */
	private class Node {
		Key key;
		Value val;
		Node next;

		public Node(Key key, Value val, Node next) {
			this.key = key;
			this.val = val;
			this.next = next;
		}
	}

	private Node head;
	private int n; // number of key-value pairs

	public int size() {
		return n;
	}

	public boolean contains(Key key) {
		if (key == null)
			throw new IllegalArgumentException("argument to contains() is null");
		return get(key) != null;
	}

	public Value get(Key key) {
		if (key == null)
			throw new IllegalArgumentException("argument to get() is null");
		Node node = head;
		while (node != null) {
			if (key.equals(node.key)) {
				return node.val; // 命中
			}
			node = node.next;
		}
		return null; // 未命中
	}

	/**
	 * 查找给定的键，找到则更新其值，否则在表中新建节点
	 * 
	 * @param key
	 *            Key
	 * @param val
	 *            Value
	 */
	public void put(Key key, Value val) {
		if (key == null)
			throw new IllegalArgumentException("first argument to put() is null");
		if (val == null) {
			delete(key);
			return;
		}

		Node node = head;
		while (node != null) {
			if (key.equals(node.key)) {
				node.val = val; // 命中
				return;
			}
			node = node.next;
		}
		head = new Node(key, val, head); // 未命中
		n++;
	}

	public void delete(Key key) {
		head = delete(head, key);
	}

	private Node delete(Node node, Key key) {
		if (node == null) {
			return null;
		}
		if (key.equals(key)) {
			n--;
			return node.next;
		}
		node.next = delete(node.next, key);
		return node;
	}

	public Iterable<Key> keys() {
		Queue<Key> queue = new Queue<Key>();
		Node node = head;
		while (node != null) {
			queue.enqueue(node.key);
			node = node.next;
		}
		return queue;
	}
	
	public static void main(String[] args) {
        SequentialSearchST<String, Integer> st = new SequentialSearchST<String, Integer>();
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            st.put(key, i);
        }
        for (String s : st.keys())
            StdOut.println(s + " " + st.get(s));
    }
}
