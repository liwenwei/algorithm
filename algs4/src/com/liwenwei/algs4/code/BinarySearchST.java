/************************************************************************************
 * 有序数组中的二分查找
 * 
 * 1. BinarySearchST 可以保证数组中Comparable类型的键有序，然后使用数组的索引来搞笑的实现put和其他
 * 的操作
 * 
 * 2. 我们使用有序数组存储键的原因是，第一章中作为例子出现的经典二分查找法能够根据数组的索引大大
 * 减少每次查找所需要的比较次数。我们会使用有序索引数组来标识被朝朝的键可能存在的子数组的大小范围。
 * 在查找时，我们先将被查找的键小于中间键比较。如果被查找的键小于中间键，我们就在左子树查找。如果大于
 * 我们就在左子树中继续查找，否则中间键就是我们要查找的键。
 * 
 ***********************************************************************************/

package com.liwenwei.algs4.code;

import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class BinarySearchST<Key extends Comparable<Key>, Value> {
	private static final int INIT_CAPACITY = 2;
	private Key[] keys;
	private Value[] vals;
	private int N;

	public BinarySearchST() {
		this(INIT_CAPACITY);
	}

	public BinarySearchST(int capacity) {
		keys = (Key[]) new Comparable[capacity];
		vals = (Value[]) new Object[capacity];
	}

	public boolean contains(Key key) {
		if (key == null)
			throw new IllegalArgumentException("argument to contains() is null");
		return get(key) != null;
	}

	public void resize(int capacity) {
		assert capacity >= N;
		Key[] tempk = (Key[]) new Comparable[capacity];
		Value[] tempv = (Value[]) new Object[capacity];
		for (int i = 0; i < N; i++) {
			tempk[i] = keys[i];
			tempv[i] = vals[i];
		}
		keys = tempk;
		vals = tempv;
	}

	public int size() {
		return N;
	}

	public int size(Key lo, Key hi) {
		if (lo == null)
			throw new IllegalArgumentException("first argument to size() is null");
		if (hi == null)
			throw new IllegalArgumentException("second argument to size() is null");

		if (lo.compareTo(hi) > 0) {
			return 0;
		}
		if (contains(hi)) {
			return rank(hi) - rank(lo) + 1;
		} else {
			return rank(hi) - rank(lo);
		}
	}

	public boolean isEmpty() {
		return N != 0;
	}

	public Value get(Key key) {
		if (key == null)
			throw new IllegalArgumentException("argument to get() is null");
		if (isEmpty()) {
			return null;
		}
		int i = rank(key);
		if (i < N && keys[i].compareTo(key) == 0) {
			return vals[i];
		} else {
			return null;
		}
	}

	/**
	 * 排序
	 * 
	 * 实现二分查找有两种办法，一种是通过递归，一种是迭代，在这里我们用迭代实现
	 * 
	 * @param key Key
	 * @return index
	 */
	public int rank(Key key) {
		int low = 0;
		int high = N - 1;
		while (low <= high) {
			int mid = low + (high + low) / 2;
			int cmp = key.compareTo(keys[mid]);
			if (cmp < 0) {
				high = mid - 1;
			} else if (cmp > 0) {
				low = mid + 1;
			} else {
				return mid;
			}
		}
		return low;
	}

	public void put(Key key, Value val) {
		if (key == null)
			throw new IllegalArgumentException("first argument to put() is null");

		if (val == null) {
			delete(key);
			return;
		}

		// key is already in table
		int i = rank(key);
		if (i < N && keys[i].compareTo(key) == 0) {
			vals[i] = val;
			return;
		}

		// insert new key-value pair
		if (N == keys.length) {
			resize(2 * keys.length);
		}

		for (int j = N; j > i; j--) {
			keys[j] = keys[j - 1];
			vals[j] = vals[j - 1];
		}
		keys[i] = key;
		vals[i] = val;
		N++;

		assert check();
	}

	public void delete(Key key) {
		if (key == null)
			throw new IllegalArgumentException("argument to delete() is null");
		if (isEmpty())
			return;

		int i = rank(key);

		// key not in table
		if (i == N || keys[i].compareTo(key) != 0) {
			return;
		}

		for (int j = i; j < N - 1; j++) {
			keys[j] = keys[j + 1];
			vals[j] = vals[j + 1];
		}

		N--;
		keys[N] = null; // to avoid loitering
		vals[N] = null;

		// resize if 1/4 full
		if (N > 0 && N == keys.length / 4) {
			resize(keys.length / 2);
		}
	}

	public void deleteMin() {
		if (isEmpty())
			throw new NoSuchElementException("Symbol table underflow error");
		delete(min());
	}

	public void deleteMax() {
		if (isEmpty())
			throw new NoSuchElementException("Symbol table underflow error");
		delete(max());
	}

	public Key min() {
		if (isEmpty())
			throw new NoSuchElementException("called min() with empty symbol table");
		return keys[0];
	}

	public Key max() {
		if (isEmpty())
			throw new NoSuchElementException("called max() with empty symbol table");
		return keys[N - 1];
	}

	public Key select(int k) {
		if (k < 0 || k >= size()) {
			throw new IllegalArgumentException("called select() with invalid argument: " + k);
		}
		return keys[k];
	}

	public Key floor(Key key) {
		if (key == null)
			throw new IllegalArgumentException("argument to floor() is null");
		int i = rank(key);
		if (i < N && key.compareTo(keys[i]) == 0) {
			return keys[i];
		}

		if (i == 0) {
			return null;
		} else {
			return keys[i - 1];
		}
	}

	public Key ceiling(Key key) {
		if (key == null)
			throw new IllegalArgumentException("argument to ceiling() is null");
		int i = rank(key);
		if (i == N) {
			return null;
		} else {
			return keys[i];
		}
	}

	public Iterable<Key> keys() {
		return keys(min(), max());
	}

	public Iterable<Key> keys(Key low, Key high) {
		Queue<Key> q = new Queue<Key>();
		for (int i = rank(low); i < rank(high); i++) {
			q.enqueue(keys[i]);
		}
		if (contains(high)) {
			q.enqueue(keys[rank(high)]);
		}
		return q;
	}

	/***************************************************************************
	 * Check internal invariants.
	 ***************************************************************************/

	private boolean check() {
		return isSorted() && rankCheck();
	}

	private boolean isSorted() {
		for (int i = 0; i < N - 1; i++) {
			if (keys[i].compareTo(keys[i + 1]) > 0) {
				return false;
			}
		}
		return true;
	}

	private boolean rankCheck() {
		for (int i = 0; i < N; i++) {
			if (i != rank(select(i))) {
				return false;
			}
		}
		for (int i = 0; i < N; i++) {
			if (keys[i].compareTo(select(rank(keys[i]))) != 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		BinarySearchST<String, Integer> st = new BinarySearchST<String, Integer>();
		for (int i = 0; !StdIn.isEmpty(); i++) {
			String key = StdIn.readString();
			st.put(key, i);
		}
		for (String s : st.keys())
			StdOut.println(s + " " + st.get(s));
	}

}
