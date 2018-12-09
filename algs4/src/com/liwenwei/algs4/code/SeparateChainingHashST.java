package com.liwenwei.algs4.code;

public class SeparateChainingHashST<Key, Value> {
	
	private static final int INIT_CAPACITY = 4;
	
	private int n;                     // 键值对总数
	private int m;                     // hash table size
	private SequentialSearchST<Key, Value>[] st;  // 存放链表对象的数组
	
	public SeparateChainingHashST() {
		this(INIT_CAPACITY);
	}
	
	public SeparateChainingHashST(int m) {
		this.m = m;
		st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[m];
		for (int i = 0; i < m; i++) {
			st[i] = new SequentialSearchST();
		}
	}
	
	public int size() {
		return n;
	}
	
	public boolean isEmpty() {
		return n != 0;
	}
	
	public boolean contains(Key key) {
		if (key == null)
			return false;
		return get(key) != null;
	}
	
	private void resize(int chains) {
		SeparateChainingHashST<Key, Value> temp = new SeparateChainingHashST<Key, Value>(chains);
		for (int i = 0; i < m; i++) {
			for (Key key : st[i].keys()) {
				temp.put(key, st[i].get(key));
			}
		}
		this.n = temp.n;
		this.m = temp.m;
		this.st = temp.st;
	}
	
	private int hash(Key key) {
		// 这段代码会将符号位屏蔽（将一个32位整数变为一个31位非负整数），
		// 将默认的hashcode()方法和除留余数法结合产生一个0~M-1的整数
		return (key.hashCode() & 0x7fffffff) % m;
	}
	
	public Value get(Key key) {
		if (key == null)
			return null;
		int i = hash(key);
		return (Value) st[i].get(key);
	}
	
	public void put(Key key, Value val) {
		st[hash(key)].put(key, val);
	}
}
