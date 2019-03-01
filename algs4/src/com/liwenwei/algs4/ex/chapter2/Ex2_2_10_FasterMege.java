/*****************************************************************
 * 2.2.10 快速归并。实现一个merge方法，按降序将a[]的后半部分复制到aux[]，
 * 然后将其归并会a[]中。这样就可以去掉内循环中检测某半边是否用尽的代码。
 * 
 * 
 * @author liwenwei
 * 
 ****************************************************************/
package com.liwenwei.algs4.ex.chapter2;

import java.util.Arrays;

public class Ex2_2_10_FasterMege {

	/**
	 * <b>这个算法相较于{@link com.liwenwei.algs4.code.Merge#merge}做了一些优化，做了一个精巧的结构设计，
	 * 按降序将a[]的后半段复制到aux[]中，然后再归并。</b>
	 * <p>例如a = {2,5,11,4,9,10}, 按降序将a后半段复制到aux结果为{2，5，11，10，9，4}</p>
	 * <p>为什么这样就能去掉检测某半边是否用尽的判断条件呢？</p>
	 * <p>因为左右扫描指针 i->..<-j 从左右两侧向中间扫描的过程中，每次取得当前值都是左边的最小值和右边的最大值
	 * 就算某一边用尽到边界值，当前也是最大和最小值</p>
	 * @param a   array
	 * @param aux aux array
	 * @param low low index
	 * @param mid mid index
	 * @param high high index
	 */
	private static void merge(Comparable[] a, Comparable[] aux, int low, int mid, int high) {
		// 前半段升序取值, 后半段降序取值
		// 例如[0,1,2,3,4,5,6,7]处理结果为[0,1,2,3,7,6,5,4]
		for (int i = low; i <= high; i++) {
			if (i <= mid) { // 前半段升序取值
				aux[i] = a[i];
			} else { // 后半段降序取值
				aux[i] = a[high - i + mid];
			}
		}
		int i = low;  // 从左向右扫描指针
		int j = high; // 从右向左扫描指针
		for (int k = low; k <= high; k++) {
			 if (less(aux[j], aux[i]))  a[k] = aux[j++];
			 else                       a[k] = aux[i++];
		}
	}

	// A typical Divide and Conquer
	private static void sort(Comparable[] a, Comparable[] aux, int low, int high) {
		if (low >= high)
			return;
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

	public static void main(String[] args) {
		Integer[] a = { 6, 4, 10, 9, 7, 7, 8, 10, 8, 9, 10 };
		sort(a);
		System.out.println(Arrays.toString(a));
	}
}
