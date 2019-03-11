/****************************************************************************
 * 2.4.25 计算数论(Computational number theory)
 * 
 * 编写程序CubeSum.java，在不适用额外空间的条件下，按大小顺序答应所有a^3+b^3的结果，其中a和b为0至N之间的整数。
 * 也就是说，不要全部计算N^2个和然后排序，而是创建一个最小优先队列，初始状态为（0^3，0，0），（1^3，1，0），（2^3，2，0）... （N^3，N，0）.
 * 这样只要优先队列非空，删除并打印最小的元素（i^3+j^3, i, j）。然后如果j<N，插入元素（i^3+（j+1）^3, i, j+1）.
 * 
 * 用这段程序找出0到10^6之间所有满足a^3+b^3=c^3+b^3的不同整数的a，b，c，d。
 * 
 * @author liwenwei
 *
 ***************************************************************************/
package com.liwenwei.algs4.ex.chapter2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Ex2_4_25_CubeSum {
	
	private class NumPair implements Comparable<NumPair> {
		int value;
		int i;
		int j;
		
		private NumPair(int value, int i, int j) {
			this.value = value;
			this.i = i;
			this.j = j;
		}
		
		@Override
		public int compareTo(NumPair o) {
			return Integer.valueOf(this.value).compareTo(Integer.valueOf(o.value));
		}
	}
	
	private void initPriorityQueue(PriorityQueue<NumPair> pq, int n) {
		for (int i = 0; i <= n; i++) {
			pq.add(new NumPair(i * i * i, i, 0));
		}
	}
	
	private void findDistinctMintegers(Map<Integer, List<NumPair>> valsMap, NumPair smallest) {
		List<NumPair> vals = new ArrayList<>();
		if (valsMap.containsKey(smallest.value)) {
			vals = valsMap.get(smallest.value);
		}
		
		for (NumPair numPair : vals) {
			if (smallest.value == numPair.value
					&& smallest.i != numPair.i
					&& smallest.i != numPair.j
					&& smallest.j != numPair.i
					&& smallest.j != numPair.j
					&& smallest.i != numPair.j
					&& numPair.i != numPair.j) {
				System.out.println(numPair.value + " A: " + numPair.i + " B: " + numPair.j
						+ " C: " + smallest.i + " D: " + smallest.j);
			}
		}
		vals.add(smallest);
		valsMap.put(smallest.value, vals);
	}
	
	public void cubeSum(PriorityQueue<NumPair> pq, int n) {
		initPriorityQueue(pq, n);
		
		Map<Integer, List<NumPair>> valsMap = new HashMap<>();
		while (!pq.isEmpty()) {
			NumPair smallest = pq.poll();
			findDistinctMintegers(valsMap, smallest);
			/* print the smallest item*/
			/* System.out.println(min.value + " " + min.i + " " + min.j); */
			if (smallest.j < n) {
				int i = smallest.i;
				int j = smallest.j + 1;
				pq.add(new NumPair(i * i * i + j * j * j, i, j));
			}
		}
	}
	
    public static void main(String[] args) {
		Ex2_4_25_CubeSum cubeSum = new Ex2_4_25_CubeSum();
		int n = 100;
		PriorityQueue<NumPair> pQueue = new PriorityQueue<>(n);
		cubeSum.cubeSum(pQueue, n);
	}
	
}
