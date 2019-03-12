/*****************************************************************
 * 基于最大堆的优先队列
 * 
 * @author liwenwei
 * 
 ****************************************************************/
package com.liwenwei.algs4.code;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class MaxPriorityQueue<Key extends Comparable<Key>> {
	
	private Key[] pq;    // 基于堆的完全二叉树
	private int N = 0;   // 存储于pq[1..N]中，pq[0]没有使用
	
	public MaxPriorityQueue() {
		this(1);
	}
	
	public MaxPriorityQueue(int capacity) {
		// 长度为什么要使用N+1呢？pq[0]没有使用
		// 如果heap从位置0开始，则k从0开始，求子节点k*2, k*2 + 1, 则为0，和1,这样跟实际的子节点位置1,2是不符的，
		// 所以在实际的使用中，为了避免这种错误k就必须从1开始，然后获取根据k去获取数组元素时要相应-1，即pq[k-1]
		// 例如exchange(i, j), 在实际代买为 <code>object temp = pq[i-1];pq[i-1] = pq[j-1];pq[j-1] = temp</code>
		// 所以为了避免这样重复的操作，选择将capacity+1， 然后数组索引从1开始
		pq = (Key[]) new Comparable[capacity + 1];
	}
	
	public MaxPriorityQueue(Key[] a) {
		
	}
	
	private void resize(int capacity) {
		assert capacity > N;
		Key[] temp = (Key[]) new Comparable[capacity];
		for (int i = 1; i <= N; i++) {
			temp[i] = pq[i];
		}
		pq = temp;
	}
	
	public void insert(Key v) {
		if (N < pq.length - 1) resize(pq.length * 2);
		pq[++N] = v;
		swim(N);
		assert isMaxHeap(1);
	}
	
	private boolean less(int i, int j) {
		return pq[i].compareTo(pq[j]) < 0;
	}
	
	private void exch(int i, int j) {
		Key t = pq[i];
		pq[i] = pq[j];
		pq[j] = t;
	}
	
	/**
	 * 由下至上的堆有序化（上浮）
	 * 
	 * @param k 节点索引
	 */
	private void swim(int k) {
		while (k > 1 && less(k/2, k)) {
			exch(k/2, k);
			k = k/2;
		}
	}
	
	/**
	 * 由上至下的堆有序化（下沉）
	 * 
	 * @param k
	 */
	private void sink(int k) {
		while (2 * k < N) {
			int j = 2 * k;
			if (less(j, j + 1)) j++; // 找出左右子节点的最大值
			if (!less(k, j)) break;
			exch(k, j); // 将子节点的最大值和k交换
			k = j;
		}
	}
	
	public Key max() {
		return pq[1];
	}
	
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
	
	public Key delMax() {
		Key max = pq[1];    // 共根节点得到最大元素
		exch(1,  N--);      // 将其和最后一个节点交换
		pq[N+1] = null;     // 将最后一个节点设置为null，防止越界
		sink(1);            // 恢复堆的有序性
		if (N < (pq.length - 1) / 4) resize((pq.length - 1) / 2);
		assert isMaxHeap(1);
		return max;
	}
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	public int size() {
		return N;
	}
	
	private boolean isMaxHeap(int k) {
		if (k > N) return true;
		int left = k * 2;
		int right = k * 2 + 1;
		if (left < N && less(k, left)) return false;
		if (right < N && less(k, right)) return false;
		return isMaxHeap(left) && isMaxHeap(right);
	}
	
	public static void main(String[] args) {
		MaxPriorityQueue<String> pq = new MaxPriorityQueue<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) pq.insert(item);
            else if (!pq.isEmpty()) StdOut.print(pq.delMax() + " ");
        }
        while (!pq.isEmpty()) {
        	StdOut.println(pq.delMax());
        }
    }
}
