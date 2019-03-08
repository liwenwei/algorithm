/*****************************************************************
 * 基于最小堆的优先队列
 * 
 * @author liwenwei
 * 
 ****************************************************************/
package com.liwenwei.algs4.code;

import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class MinPriorityQueue<Key extends Comparable<Key>> {
	private Key[] pq;    // 基于堆的完全二叉树
	private int N = 0;   // 存储于pq[1..N]中，pq[0]没有使用
	
	public MinPriorityQueue() {
		this(1);
	}
	
	public MinPriorityQueue(int capacity) {
		pq = (Key[]) new Comparable[capacity + 1];
	}
	
	public MinPriorityQueue(Key[] a) {
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
		if (N == pq.length - 1) resize(2 * pq.length);
		pq[++N] = v;
		swim(N);
		assert isMinHeap(1);
	}
	
	private boolean less(int i, int j) {
		return pq[i].compareTo(pq[j]) < 0;
	}
	
	private void exch(int i, int j) {
		Key t = pq[i];
		pq[i] = pq[j];
		pq[j] = t;
	}
	
	private void swim(int k) {
		while (k > 1 && less(k, k/2)) {
			exch(k/2, k);
			k = k/2;
		}
	}
	
	private void sink(int k) {
		while (2 * k <= N) {
			int j = 2 * k;
			if (j < N && less(j + 1, j)) j++; // 找出左右子节点的最小值
			if (less(k, j)) break;
			exch(k, j); // 将子节点的最大值和k交换
			k = j;
		}
	}
	
	public Key min() {
		if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
		return pq[1];
	}
	
	public Key delMin() {
		Key min = pq[1];    // 共根节点得到最小元素
		exch(1,  N--);      // 将其和最后一个节点交换
		pq[N+1] = null;     // 将最后一个节点设置为null，防止越界
		sink(1);            // 恢复堆的有序性
		if (N < (pq.length - 1) / 4) resize((pq.length - 1) / 2);
		assert isMinHeap(1);
		return min;
	}
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	public int size() {
		return N;
	}
	
	private boolean isMinHeap(int k) {
		if (k > N) return true;
		int left = k * 2;
		int right = k * 2 + 1;
		if (left < N && less(left, k)) return false;
		if (right < N && less(right, k)) return false;
		return isMinHeap(left) && isMinHeap(right);
	}
	
	public static void main(String[] args) {
        MinPriorityQueue<String> pq = new MinPriorityQueue<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) pq.insert(item);
            else if (!pq.isEmpty()) StdOut.print(pq.delMin() + " ");
        }
        StdOut.println("(" + pq.size() + " left on pq)");
        while (!pq.isEmpty()) {
        	StdOut.println(pq.delMin());
        }
    }
}
