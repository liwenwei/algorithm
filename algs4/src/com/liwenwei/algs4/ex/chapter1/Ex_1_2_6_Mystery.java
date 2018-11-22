package com.liwenwei.algs4.ex.chapter1;

public class Ex_1_2_6_Mystery {
	
	public static void main(String[] args) {
		System.out.println(mystery("liwenwei"));
	}
	
	public static String mystery(String s) {
		int N = s.length();
		if (N <= 1) return s;
		String a = s.substring(0, N/2);
		String b = s.substring(N/2, N);
		return mystery(b) + mystery(a);
	}
	
}
