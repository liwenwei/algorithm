/****************************************************************************
 * 2.4.13 想办法在sink()中避免j < N
 * 
 * @author liwenwei
 *
 ***************************************************************************/
package com.liwenwei.algs4.ex.chapter2;

import com.liwenwei.algs4.code.MaxPriorityQueue;

public class Ex2_4_13_Condition {

	
	// 想办法在sink()中避免j < N
	// 将while的condition 2*k<=N 改为2*k<N， 然后去掉j < N
	/*
	private void sink(int k) {
		while (2 * k < N) {
			int j = 2 * k;
			if (less(j, j + 1)) j++; // 找出左右子节点的最大值
			if (!less(k, j)) break;
			exch(k, j); // 将子节点的最大值和k交换
			k = j;
		}
	}
	*/
}
