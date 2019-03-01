/*****************************************************************
 * 问题描述：
 * <p>设A[1..n]是一个包含n个不同数的数组。如果在i<j的情况下，有A[i]>A[j]，则(i, j)就称为A中的一个
 * 逆序对（inversion）。给出一个算法，它能用Θ(nlgn)的最坏运行时间，确定n个元素的任何排列中逆序对的数目。</p>
 * 算法思想：
 * <p>算法实现类似于合并排序，但需要额外处理逆序数的计数。因此，逆序数的计算相当于合并排序的副产品。
 * 在下面的代码中将global num </p>
 * 
 * @author liwenwei
 * 
***************************************************************/

package com.liwenwei.algs4.ex.chapter2;

import java.util.Arrays;

public class Ex2_2_19_Inversions {

	public static void main(String[] args) {
		Ex2_2_19_Inversions inversions = new Ex2_2_19_Inversions();
		int[] a = { 2, 1, 4, 3 };
		System.out.println(inversions.count(a));
	}

	int count = 0;

	// 具体可参考归并排序
	public int count(int[] a) {
		count = 0;
		int[] aux = new int[a.length];
		mergeSort(a, aux, 0, a.length - 1);
		return count;
	}

	private void mergeSort(int[] a, int[] aux, int low, int high) {
		if (low >= high)
			return;
		int mid = (high - low) / 2 + low;
		mergeSort(a, aux, low, mid);
		mergeSort(a, aux, mid + 1, high);
		merge(a, aux, low, high);
	}

	private void merge(int[] a, int[] aux, int low, int high) {
		int mid = (high - low) / 2 + low;
		int i = low;
		int j = mid + 1;;

		for (int k = low; k <= high; k++) {
			aux[k] = a[k];
		}

		for (int k = low; k <= high; k++) {
			if (i > mid) {
				a[k] = aux[j++];
			} else if (j > high) {
				a[k] = aux[i++];
			} else if (aux[i] > aux[j]) {
				a[k] = aux[j++];
				count++;
			} else {
				a[k] = aux[i++];
			}
		}
	}

}
