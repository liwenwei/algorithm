/*****************************************************************
 * 2.3.17 哨兵
 * 
 * 修改算法2.5，去掉内循环while中的边界检查。由于切分元素本身就是一个哨兵（v
 * 不可能小于a[low]，左侧边界的检查是多余的。只要去掉另一个检查，可以在打乱数组
 * 后将数组的最大元素放在a[length-1]中。该元素永远不会移动（除非和相等的元素交换），
 * 可以在所有包含它的子数组中称为哨兵。
 * 
 * 注意：在处理内部子数组时，右子数组中最左侧的元素可以作为左子数组右边界的哨兵
 * 
 * @author liwenwei
 * 
 ****************************************************************/
package com.liwenwei.algs4.ex.chapter2;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdRandom;

public class Ex2_3_17_QuickSortWithSentinel {

	public static void main(String[] args) {
		Integer[] a = { 6, 4, 10, 9, 7, 7, 8, 10, 8, 9, 10 };
		sort(a);
		System.out.println(Arrays.toString(a));
	}
	
	private static int partition(Comparable[] a, int low, int high) {
		int i = low, j = high + 1;
		Comparable v = a[low];
		while (true) {
			while (less(a[++i], v));  // 最大元素放在a[length-1]，该元素永远不会移动（除非相等的元素交换）
			while (less(v, a[--j]));  // 由于切分元素本身就是一个哨兵（v不可能小于a[low]，左侧边界的检查是多余的
			if (i >= j) break;
			exch(a, i, j);
		}
		exch(a, low, j);
		return j;
	}
	
	public static void sort(Comparable[] a) {
		StdRandom.shuffle(a);
		int maxIndex = 0;
		for (int i = 0; i < a.length; i++) {
			if (less(a[maxIndex], a[i])) {
				maxIndex = i;
			}
		}
		exch(a, maxIndex, a.length - 1); // 将最大元素放在a[length-1]中
		sort(a, 0, a.length - 1);
	}
	
	private static void sort(Comparable[] a, int low, int high) {
		if (low >= high) return;
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
	
}
