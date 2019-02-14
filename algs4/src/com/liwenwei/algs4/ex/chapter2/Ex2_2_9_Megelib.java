/*****************************************************************
 * 2.2.9 在库函数中使用aux[]这样的静态数组是不妥当的，因为可能会有多个程序
 * 同时使用这个类 。
 * 
 * <b>注意：在多线程（线程安全）的环境下，定义静态的变量很容易造成数据混淆，所以在
 * coding时，尽量避免定义全局静态变量，可以考虑传递参数的办法</b>
 * 
 * @author liwenwei
 * 
 ****************************************************************/
package com.liwenwei.algs4.ex.chapter2;

public class Ex2_2_9_Megelib {

	// Merge a[low .. mid] with a[mid+1 .. high] using aux[low .. high]
	private void merge(Comparable[] a, Comparable[] aux, int low, int mid, int high) {
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
			if (i > mid)
				a[k] = aux[j++];
			else if (j > high)
				a[k] = aux[i++];
			else if (less(aux[j], aux[i]))
				a[k] = aux[j++];
			else
				a[k] = aux[i++];
		}
	}

	// A typical Divide and Conquer
	private void sort(Comparable[] a, Comparable[] aux, int low, int high) {
		if (low >= high)
			return;
		int mid = low + (high - low) / 2;
		sort(a, aux, low, mid);
		sort(a, aux, mid + 1, high);
		merge(a, aux, low, mid, high);
	}

	public void sort(Comparable[] a) {
		Comparable[] aux = new Comparable[a.length];
		sort(a, aux, 0, a.length - 1);
	}

	private boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	private void exch(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
}
