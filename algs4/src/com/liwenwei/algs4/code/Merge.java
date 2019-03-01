/*****************************************************************
 * 自顶向下的归并排序（Top-down mergesort）
 * 
 * 通过一些细致的思考，我们还能够大幅度缩短归并排序的运行时间
 * 1. 对小规模子数组使用插入排序
 * 2. 测试数组是否已经有序
 * 3. 不将元素复制到辅助数组
 * 
 * @author liwenwei
 * 
 ****************************************************************/
package com.liwenwei.algs4.code;

import java.util.Arrays;

public class Merge {
	
	// This class should not be instantiated
	private Merge() {}
	
	// Merge a[low .. mid] with a[mid+1 .. high] using aux[low .. high]
	private static void merge(Comparable[] a, Comparable[] aux, int low, int mid, int high) {
		for (int k = low; k <= high; k++) {
			aux[k] = a[k];
		}
		
		int i = low, j = mid + 1;
		// 四个判定条件
		// 1. 左半边用尽（取右半边元素）
		// 2. 右半边用尽（取左半边元素）
		// 3. 右半边当前元素小于左半边当前元素（取右半边当前元素）
		// 4. 左半边当前元素小于右半边当前元素（取左半边当前元素）
		for (int k = low; k <= high; k++) {
			if (i > mid)                    a[k] = aux[j++];
			else if (j > high)              a[k] = aux[i++];
			else if (less(aux[j], aux[i]))  a[k] = aux[j++];
			else                            a[k] = aux[i++];
		}
	}
	
	// A typical Divide and Conquer
	private static void sort(Comparable[] a, Comparable[] aux, int low, int high) {
		if (low >= high) return;
		int mid = low + (high - low) / 2;
		sort(a, aux, low, mid);
		sort(a, aux, mid + 1, high);
		merge(a, aux, low, mid, high);
	}
	
	public static void sort(Comparable[] a) {
		Comparable[] aux = new Comparable[a.length];
		sort(a, aux, 0, a.length - 1);
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
		Merge.sort(a);
		System.out.println(Arrays.toString(a));
	}
}
