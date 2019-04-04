package com.liwenwei.algs4.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Logger;

public class test {

	public static void main(String[] args) {
		
		int[] a = {1,2,3};
		Arrays.sort(a);
		
		MaxPriorityQueue<Integer> maxPQ = new MaxPriorityQueue<>();
		maxPQ.insert(2);
		maxPQ.insert(5);
		maxPQ.insert(1);
		maxPQ.insert(4);
		maxPQ.insert(8);
		maxPQ.insert(7);
		System.out.println(maxPQ.delMax());
		System.out.println(maxPQ.min());
		System.out.println(maxPQ.delMax());
		System.out.println(maxPQ.min());
		System.out.println(maxPQ.delMax());
		System.out.println(maxPQ.min());
	}

	private static void sort(Comparable[] a, int lo, int hi) { // See page 289 for public sort() that calls this method.
		if (hi <= lo)
			return;
		int lt = lo, i = lo + 1, gt = hi;
		Comparable v = a[lo];
		while (i <= gt) {
			int cmp = a[i].compareTo(v);
			if (cmp < 0)
				exch(a, lt++, i++);
			else if (cmp > 0)
				exch(a, i, gt--);
			else
				i++;
			
			System.out.println(Arrays.toString(a));
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

	private static void mergeSort(int[] arr, int lo, int hi) {
		int mid = (hi - lo) / 2 + lo;
		int i = lo, j = mid;
		int[] aux = new int[arr.length];
		for (int k = 0; k < arr.length; k++)
			aux[k] = arr[k];

		for (int k = 0; k < hi; k++) {
			if (i > mid) {
				arr[k] = aux[j++];
			} else if (j > hi) {
				arr[k] = aux[i++];
			} else if (aux[j] < aux[i]) {
				arr[k] = aux[j++];
			} else {
				arr[k] = aux[i++];
			}
		}

	}

	private static void bubbleSort(int[] arr) {
		for (int i = arr.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}

	private static void bubbleSort1(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}

	public static void printClassLoaders() throws ClassNotFoundException {
		System.out.println("Class loader of this class:" + test.class.getClassLoader());

		System.out.println("Class loader of this class:" + Logger.class.getClassLoader());

		System.out.println("Class loader of this class:" + ArrayList.class.getClassLoader());
	}

}
