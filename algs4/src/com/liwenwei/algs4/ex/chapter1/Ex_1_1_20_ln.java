package com.liwenwei.algs4.ex.chapter1;

public class Ex_1_1_20_ln {
	
	private static int ln(int N) {
		if (N == 0) { 
			return 1;
		} else {
			return ln(N - 1) * N;
		}
		
	}
	
	public static void main(String[] args) { 
		System.out.println(ln(5));
		System.out.println(ln(0));
	}
}
