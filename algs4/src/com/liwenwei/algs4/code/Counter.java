package com.liwenwei.algs4.code;

public class Counter {
	
	private String id;
	private int total = 0;
	
	public Counter(String id) {
		this.id = id;
	}
	
	public void increment() {
		total++;
	}
	
	public int tally() {
		return total;
	}
	
	@Override
	public String toString() {
		return id;
	}
}
