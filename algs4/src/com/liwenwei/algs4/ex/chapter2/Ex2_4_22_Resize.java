/****************************************************************************
 * 2.4.22 Resize
 * 
 * @author liwenwei
 *
 ***************************************************************************/
package com.liwenwei.algs4.ex.chapter2;

public class Ex2_4_22_Resize {

	private int capacity = 10;
	private int N = 0;
	private int[] a;

	private void insert() {
		if (N > capacity / 2) resize(N * 2);
		// insert
		// ...
		N++;
	}

	private void delete() {
		// insert
		// ...
		if (N < capacity / 4) resize(capacity / 2);
		N--;
	}

	private void resize(int capacity) {
		this.capacity = capacity;
		int[] temp = new int[capacity];
		for (int i = 0; i < N; i++) {
			temp[i] = a[i];
		}
		a = temp;
	}

}
