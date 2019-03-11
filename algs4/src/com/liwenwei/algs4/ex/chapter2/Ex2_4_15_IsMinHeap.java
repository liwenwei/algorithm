/****************************************************************************
 * 2.4.15 设计一个程序，在线性时间内检测数组是否是一个最小堆
 * 
 * @author liwenwei
 *
 ***************************************************************************/
package com.liwenwei.algs4.ex.chapter2;

public class Ex2_4_15_IsMinHeap {

	public static void main(String[] args) {
		int[] a = {1, 2, 3, 4, 5, 6, 7};
		System.out.println(isMinHeap(a));
		
		int[] a1 = {1, 4, 3, 2, 5, 6, 7};
		System.out.println(isMinHeap(a1));
	}
	
	public static boolean isMinHeap(int[] a) {
		return _isMinHeap(a, 1, a.length);
	}
	
	public static boolean _isMinHeap(int[] a, int k, int N) {
		if (k > N) return true;
		int left = 2 * k;
		int right = 2 * k + 1;
		if (left < N && a[k - 1] > a[left - 1]) return false;
		if (right < N && a[k - 1] > a[right - 1]) return false;
		return _isMinHeap(a, left, N) && _isMinHeap(a, right, N);
	}
	
}
