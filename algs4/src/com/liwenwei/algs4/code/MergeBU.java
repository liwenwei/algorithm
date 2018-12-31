/*****************************************************************
 * 自底向上的归并排序（Bottom-up mergesort）
 * 
 * 首先我们进行的是两两归并（把每个元素想象成一个大小为1的数组），然后四四归并（将两个大小为2
 * 的数组归并成一个有四个元素的数组），然后八八的归并一直下去
 * 1->2->4->8->16->...
 * 
 * @author liwenwei
 * 
 ****************************************************************/
package com.liwenwei.algs4.code;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdIn;

public class MergeBU {
	
	// This class should not be instantiated
	private MergeBU() {}
	
	// Merge a[low .. mid] with a[mid+1 .. high] using aux[low .. high]
	private static void merge(Comparable[] a, Comparable[] aux, int low, int mid, int high) {
		for (int k = 0; k < a.length; k++) {
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
	
	// Rearranges the array in ascending order, using the natural order
	// 要merge（归并）的子数组长度是2的幂（1，2，4，8...）
	public static void sort(Comparable[] a) {
		int n = a.length;
		Comparable[] aux = new Comparable[n];
		// subarray size: 1, 2, 4, 8...
		for (int len = 1; len < n; len *= 2) {
			for (int low = 0; low < n - len; low += len + len) {
				int mid = low + len - 1;
				int high = Math.min(low + len + len - 1, n - 1);
				// merge two subarrays: [low..mid-1], [mid..len+len]
				merge(a, aux, low, mid, high);
			}
		}
	}
	
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	// swap
	private static void exch(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	private static boolean isSorted(Comparable[] a) {
		for (int i = 1; i < a.length; i++) {
			if (less(a[i], a[i - 1]))
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        MergeBU.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
