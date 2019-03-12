/*****************************************************************
 * 2.4.27 找出最小元素。在MaxPQ中加入一个min()方法。你的实现所需的时间和空间
 * 都应该是常数。
 * 
 * 解决方法：
 * 在最大堆中，最小的元素肯定在叶子节点上[N/2,N],然后再通过二分查找，找出[N/2,N]
 * 区间的最小值
 * 
 * @author liwenwei
 * 
 ****************************************************************/
package com.liwenwei.algs4.ex.chapter2;

public class Ex2_4_27_FindMin {
	
	/*
	
	// 
	public Key min() {
		int k = N / 2;
		int j = N;
		int minKey = k;
		while (k <= j) {
			if (less(k, minKey)) minKey = k;
			if (less(j, minKey)) minKey = j;
			k++;
			j--;
		}
		return pq[minKey];
	}
	
	*/
}
