/*****************************************************************
 * 堆排序
 * 
 * @author liwenwei
 * 
***************************************************************/
package com.liwenwei.algs4.code;

import java.util.Arrays;

public class Heap {
	
	private Heap() {
	}
	
	public static void sort(Comparable[] a) {
		int N = a.length - 1;
		// 从第一个非叶子节点开始
		for (int k = N / 2; k >= 0; k--) {
			// 将节点k最大堆化
			sink(a, k, N);
		}
		while (N > 0) {
			exch(a, 0, N--); // 将最大元素a[1]和a[N]交换，以实现排序
			sink(a, 0, N);   // 恢复最大堆化
		}
	}
	
	private static void sink(Comparable[] a, int k, int N) {
		while (k * 2 <= N) {
			int j = k * 2;
			if (j <= N && j + 1 <= N && less(a, j, j + 1)) j++;
			if (!less(a, k, j)) break;
			exch(a, k, j);
			k = j;
		}
	}
	
	private static boolean less(Comparable[] a, int i, int j) {
        return a[i].compareTo(a[j]) < 0;
    }

    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
	
    public static void main(String[] args) {
    	Integer[] a = { 8, 4, 5, 6, 1, 1, 10 };
    	Heap.sort(a);
    	System.out.println(Arrays.toString(a));
	}
    
}
