package com.liwenwei.algs4.code;

import java.util.Arrays;

public class Shell {

	public static void sort(Comparable[] a) {
		int N = a.length;
		int h = 1;
		while (h < N / 3)
			h = h * 3 + 1; // 1, 4, 13, 40, 121, 364, 1093, ...
		while (h >= 1) { 
			// h-sort the array.
			for (int i = h; i < N; i++) { 
				// Insert a[i] among a[i-h], a[i-2*h], a[i-3*h]....
				for (int j = i; j >= h && less(a[j], a[j - h]); j -= h)
					exch(a, j, j - h);
			}
			h = h / 3;
		}
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
