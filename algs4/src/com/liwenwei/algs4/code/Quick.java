/*****************************************************************
 * Quick sort
 * 
 * @author liwenwei
 * 
 ****************************************************************/
package com.liwenwei.algs4.code;

import java.util.Arrays;

public class Quick {
	
	private Quick() {
		
	}
	
	private static int partition(Comparable[] a, int low, int high) {
		int i = low, j = high + 1;
		Comparable v = a[low];
		while (true) {
			while (less(a[++i], v)) if (i == high) break;
			while (less(v, a[--j])) if (j == low) break;
			if (i > j) break;
			exch(a, i, j);
		}
		exch(a, low, j);
		return j;
	}
	
	public static void sort(Comparable[] a) {
		sort(a, 0, a.length - 1);
	}
	
	private static void sort(Comparable[] a, int low, int high) {
		if (low > high) return;
		int j = partition(a, low, high);
		sort(a, low, j - 1);
		sort(a, j + 1, high);
	}
	
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	private static void exch(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	public static boolean isSorted(Comparable[] a) {
		for (int i = 1; i < a.length; i++) {
			if (less(a[i], a[i - 1]))
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Integer[] a = { 6, 4, 10, 9, 7, 7, 8, 10, 8, 9, 10 };
		Shell.sort(a);
		System.out.println(Arrays.toString(a));
	}
}
