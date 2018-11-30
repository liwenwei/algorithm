/******************************************************************************
 * 
 *  Sorted symbol table implementation using a java.util.TreeMap.
 *  Does not allow duplicates.
 *
 ******************************************************************************/
package com.liwenwei.algs4.code;

import java.util.TreeMap;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Symbol table
 * @author liwenwei
 *
 * @param <Key>
 * @param <Value>
 */
public class ST<Key extends Comparable<Key>, Value> {
	
	private TreeMap<Key, Value> st;
	
	public ST() {
		st = new TreeMap<>();
	}
	
	/**
	 * Put the key-value pair in the table
	 * if the value is null, delete the key from the table
	 * 
	 * @param key Key
	 * @param val Value
	 */
	public void put(Key key, Value val) {
		if (val == null) {
			delete(key);
		}
		st.put(key, val);
	}
	
	/**
	 * Get the value by key. Return null if the key doesn't exist
	 * 
	 * @param key Key
	 * @return Value
	 */
	public Value get(Key key) {
		if (contains(key)) {
			return st.get(key);
		} else {
			return null;
		}
	}
	
	/**
	 * Remove the key from table
	 * 
	 * @param key Key
	 */
	public void delete(Key key) {
		st.remove(key);
	}
	
	public boolean contains(Key key) {
		return st.containsKey(key);
	}
	
	public boolean isEmpty() {
		return st.isEmpty();
	}
	
	public int size() {
		return st.size();
	}
	
	public Key min() {
		return st.firstKey();
	}
	
	public Key max() {
		return st.lastKey();
	}
	
	public Key floor(Key key) {
		return st.floorKey(key);
	}
	
	public Key ceiling(Key key) {
		return st.ceilingKey(key);
	}
	
	/**
	public int rank(Key key) {
		
	}
	
	public Key select(int k) {
		
	}
	
	public void deleteMin() {
		
	}
	
	public void deleteMax() {
		
	}
	
	public int size(Key lo, Key hi) {
		
	}
	**/
	
	public Iterable<Key> keys() {
		return st.keySet();
	}
	
	/**
	public Iterable<Key> keys(Key lo, Key hi) {
		
	}
	**/
	
	public static void main(String[] args) {
		ST<String, Integer> st = new ST<>();
		
		for (int i = 0; !StdIn.isEmpty(); i++) {
			String key = StdIn.readString();
			st.put(key, i);
		}
		
		for (String s : st.keys()) {
			StdOut.println(s + " " + st.get(s));
		}
	}
}
