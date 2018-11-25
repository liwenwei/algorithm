package com.liwenwei.algs4.code;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class FixedCapacityStack<E> extends Stack<E> {
	
	private int cap = 0;
	
	public FixedCapacityStack(int cap) {
		this.cap = cap;
	}
	
	@Override
	public void push(E item) {
		if (n >= cap) {
			throw new RuntimeException("Stack overflow");
		}
		super.push(item);
	}
	
	@Override
	public int size() {
		return cap;
	}
	
	public static void main(String[] args) {
		FixedCapacityStack<String> s = new FixedCapacityStack<String>(100);
		while (!StdIn.isEmpty()) {
			String item = StdIn.readString();
			if (!item.equals("-")) {
				s.push(item);
			} else if (!s.isEmpty()) {
				StdOut.print(s.pop() + " ");
			}
		}
		StdOut.println("(" + s.size() + " left on stack");
	}
}
