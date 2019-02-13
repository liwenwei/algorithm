/*****************************************************************
 * 2.1.4 插入排序的哨兵。
 * 
 * 在插入排序中先找出最小元素并放在数组的最左边，这样就能去掉内循环的判断条件j>0
 * 注意：这是一种常见的规避边界的方法，能够省略判断条件的元素通常被称为哨兵
 * 
 * @author liwenwei
 * 
 ****************************************************************/
package com.liwenwei.algs4.ex.chapter2;

import com.liwenwei.algs4.code.Stopwatch;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Ex2_1_24_InsertSortWithSentinel {
	
	private enum InsertionSortType {
        DEFAULT, SENTINEL;
    }
	
	public static void main(String[] args) {
		int N = 100000;
		int T = 10;
		double t1 = timeRandomInput(InsertionSortType.DEFAULT, N, T);
		double t2 = timeRandomInput(InsertionSortType.SENTINEL, N, T);
		StdOut.printf("For %d random doubles\n Insertion Sort default is", N);
		StdOut.printf(" %.1f times faster than Insertion Sort with a sentinel", t2/t1);
	}
	
	public static void insertionSortWithSentinel(Comparable[] a) {
		// 找到最小元素，并放在数组最左端
		int min = 0;
		for (int i = 0; i < a.length; i++) {
			if (less(a[i], a[min]))
				min = i;
		}
		exch(a, min, 0);
		
		for (int i = 1; i < a.length; i++) {
			// 哨兵，去掉内循环的判断条件j>0
			for (int j = i; less(a[j], a[j - 1]); j--) {
				exch(a, j, j - 1);
			}
		}
	}

	public static void insertionSort(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			// 将a[i]与a[0]到a[i-1]中比它小的元素依次交换
			for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
				exch(a, j, j - 1);
			}
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
	
	public static double time(InsertionSortType type, Comparable[] a) {
		Stopwatch timer = new Stopwatch();
		if (type == InsertionSortType.SENTINEL) {
			insertionSortWithSentinel(a);
		} else if (type == InsertionSortType.DEFAULT) {
			insertionSort(a);
		}
		return timer.elapsedTime();
	}
	
	/**
	 * 使用算法将T个长度为N的数组排序
	 * 
	 * @param alg
	 * @param N
	 * @param T
	 */
	public static double timeRandomInput(InsertionSortType type, int N, int T) {
		double total = 0;
		Comparable[] a = new Comparable[N];
		for (int i = 0; i < T; i++) {
			for (int j = 0; j < N; j++)
				a[j] = StdRandom.uniform();
			total += time(type, a);
		}
		return total;
	}
}
