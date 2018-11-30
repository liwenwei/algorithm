/*********************************************************************************
 * 1.4.18 数组的局部最小元素
 * 编写一个程序，给定一个含有N个不同整数的数组，找到一个局部最小元素： 满足a[i]<a[i-1]，且a[i]<[i+1]
 * 的索引i, 程序在最坏情况下所需要的比较次数为 ~2lgN
 * 
 * 答：检查数组的中间值a[N/2]以及和它相邻的元素a[N/2-1]和a[N/2+1]。如果a[N/2]是一个局部最小值则算法终止；
 * 否则则在较小的相邻元素的半边中继续查找。
 * 
 * http://courses.csail.mit.edu/6.006/spring11/lectures/lec02.pdf
 * http://stackoverflow.com/questions/12238241/find-local-minima-in-an-array
 * 
 *********************************************************************************/

package com.liwenwei.algs4.ex.chapter1;


public class Ex_1_4_18_LocalMinimum {
	public static void main(String[] args) {
		int[] arr = { -20, -5, -3, 0, 4, 1, 6, 8 };
		System.out.println(findLocalMin(arr));
		System.out.println("Expect 5");
	}

	public static int findLocalMin(int[] a) {
		// N = 1
		if (a.length == 1) {
			return a[0];
		}

		// N = 2
		if (a.length == 2) {
			if (a[0] < a[1]) {
				return a[0];
			} else {
				return a[1];
			}
		}

		int low = 0;
		int high = a.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;

			if (mid == 0) {
				if (a[mid] < a[mid + 1]) {
					return a[mid];
				} else {
					return -1;
				}
			}

			if (mid == a.length - 1) {
				if (a[mid] < a[mid - 1]) {
					return a[mid];
				} else {
					return -1;
				}
			}

			if (a[mid - 1] > a[mid] && a[mid + 1] > a[mid]) {
				return a[mid];
			} else if (a[mid - 1] < a[mid]) {
				high = mid - 1;
			} else if (a[mid + 1] < a[mid]) {
				low = mid + 1;
			}
		}

		return -1;
	}
}
