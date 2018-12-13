/******************************************************************
 * 
 * 稀疏向量
 * 
 * 在大型应用中，使用稀疏矩阵比使用标准数组实现矩阵向量乘法的速度提升10亿倍甚至更多
 * 
 * @author liwenwei
 *
 ******************************************************************/
package com.liwenwei.algs4.code;

import edu.princeton.cs.algs4.StdOut;

public class SparseVector {

	private ST<Integer, Double> st;

	public SparseVector() {
		st = new ST<Integer, Double>();
	}

	public int size() {
		return st.size();
	}

	public void put(int key, double val) {
		st.put(key, val);
	}

	public double get(int key) {
		if (!st.contains(key)) {
			return 0.0;
		} else {
			return st.get(key);
		}
	}

	public double dot(double[] that) {
		double sum = 0.0;
		for (int i : st.keys()) {
			sum += that[i] * this.get(i);
		}
		return sum;
	}
	
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		for (int i : st.keys()) {
			s.append(String.format("(%d, %.2f) ", i, st.get(i)));
		}
		return s.toString();
	}
	
	public static void main(String[] args) {
		SparseVector a = new SparseVector();
		a.put(3, 0.50);
		a.put(5, 1.2);
		StdOut.println(a.toString());
	}

}
