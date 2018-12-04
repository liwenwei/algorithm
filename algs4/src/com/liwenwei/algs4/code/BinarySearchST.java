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

public class BinarySearchST<Key extends Comparable<Key>, Value> {
	
	private Key[] keys;
	private Value[] vals;
	private int N;
	
	public BinarySearchST(int capacity) {
		keys = (Key[]) new Comparable[capacity];
		vals = (Value[]) new Object[capacity];
	}
	
	public boolean contains(Key key) {
		int cmp = rank(key);
		return cmp < N && keys[cmp].compareTo(key) == 0;
	}
	
	public int size() {
		return N;
	}
	
	public boolean isEmpty() {
		return N != 0;
	}
	
	public Value get(Key key) {
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
		int i = rank(key);
		if (i < N && keys[i].compareTo(key) == 0) {
			vals[i] = val;
			return;
		}
		for (int j = N; j > i; j--) {
			keys[j] = keys[j - 1];
			vals[j] = vals[j - 1];
		}
		keys[i] = key;
		vals[i] = val;
		N++;
	}
	
	public void delete(Key key) {
		int i = rank(key);
		if (i < N && keys[i].compareTo(key) == 0) {
			for (int j = i; j < N - 1; j++) {
				keys[j] = keys[j + 1];
				vals[j] = vals[j + 1];
			}
			N--;
		}
	}
	
	public Key min() {
		return keys[0];
	}
	
	public Key max() {
		return keys[N - 1];
	}
	
	public Key select(int k) {
		return keys[k];
	}
	
	public Key ceiling(Key key) {
		int i = rank(key);
		return keys[i];
	}
	
	public Key floor(Key key) {
		
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
	
}
