/******************************************************************
 * 
 * 基于线性探测的符号表
 * 
 * @author liwenwei
 *
 ******************************************************************/
package com.liwenwei.algs4.code;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class LinearProbingHashST<Key, Value> {
	private static final int INIT_CAPACITY = 4;

	private int n; // 键值对总数
	private int m; // hash table size
	private Key[] keys; // 键
	private Value[] vals; // 值

	public LinearProbingHashST() {
		this(INIT_CAPACITY);
	}

	public LinearProbingHashST(int capacity) {
		m = capacity;
		n = 0;
		keys = (Key[]) new Object[capacity];
		vals = (Value[]) new Object[capacity];
	}

	public int size() {
		return n;
	}

	public void resize(int capacity) {
		LinearProbingHashST<Key, Value> temp = new LinearProbingHashST<Key, Value>(capacity);
		for (int i = 0; i < m; i++) {
			temp.keys[i] = keys[i];
			temp.vals[i] = vals[i];
		}
		keys = temp.keys;
		vals = temp.vals;
		m = temp.m;
	}

	public boolean isEmpty() {
		return n != 0;
	}

	public boolean contains(Key key) {
		if (key == null)
			return false;
		return get(key) != null;
	}

	private int hash(Key key) {
		return (key.hashCode() & 0x7fffffff) % m;
	}

	public void put(Key key, Value val) {
		if (key == null)
			throw new IllegalArgumentException("The key is null");
		if (val == null) {
			delete(key);
			return;
		}

		if (n > m / 2) {
			resize(2 * m);
		}

		int i;
		for (i = hash(key); keys[i] != null; i = (i + 1) % m) {
			if (keys[i].equals(key)) {
				vals[i] = val;
				return;
			}
		}
		keys[i] = key;
		vals[i] = val;
		n++;
	}

	public Value get(Key key) {
		if (key == null)
			return null;
		for (int i = hash(key); keys[i] != null; i = (i + 1) % m) {
			if (keys[i].equals(key)) {
				return vals[i];
			}
		}
		return null;
	}

	/**
	 * 删除
	 * 
	 * 如何从基于先行探索的散列表中删除一个键？你会发现，如果直接将该键所在的位置设为null是不行的，因为这会 使得此位置之后的元素无法被查找，
	 * 因此我们需要将簇中被删除键的右侧的所有键重新插入散列表。
	 * 
	 * 删除键的过程实际上正好和 for (int i = hash(key); keys[i] != null; i = (i + 1) % m) { if
	 * (keys[i].equals(key)) { return vals[i]; } }
	 * 
	 * 相反
	 * 
	 * @param key
	 *            Key
	 */
	public void delete(Key key) {
		if (key == null)
			return;
		if (!contains(key))
			return;
		int i = hash(key);
		while (key.equals(keys[i])) {
			i = (i + 1) % m;
		}
		keys[i] = null;
		vals[i] = null;
		while (keys[i] != null) {
			Key keyToRedo = keys[i];
			Value valToRedo = vals[i];
			keys[i] = null;
			vals[i] = null;
			n--;
			put(keyToRedo, valToRedo);
			i = (i + 1) % m;
		}
		n--;
		if (n > 0 && n == m / 8)
			resize(m / 2);
	}

	public Iterable<Key> keys() {
		Queue<Key> queue = new Queue<Key>();
		for (int i = 0; i < n; i++) {
			queue.enqueue(keys[i]);
		}
		return queue;
	}

	public static void main(String[] args) {
		LinearProbingHashST<String, Integer> st = new LinearProbingHashST<String, Integer>();
		for (int i = 0; !StdIn.isEmpty(); i++) {
			String key = StdIn.readString();
			st.put(key, i);
		}

		// print keys
		for (String s : st.keys())
			StdOut.println(s + " " + st.get(s));
	}
}
