/*********************************************************************************
 * 1.4.16
 * 最接近的一对（一维）。编写一个程序，给定一个含有N个double值得数组a[]，在其中找到一对
 * 最接近的值：两者之差（绝对值）最小的两个数。程序在最坏情况下所需的运行时间应该是线性对数级别的
 * 
 *********************************************************************************/

package com.liwenwei.algs4.ex.chapter1;

import java.util.Arrays;

public class Ex_1_4_16_ClosestPair {

	public static void main(String[] args) {
		double[] arr = { -20, -5, -3, 0, 1, 1, 6, 8 };
		System.out.println(Arrays.toString(findClosestDiffPair(arr)));
	}

	public static double[] findClosestDiffPair(double[] a) {
		Arrays.sort(a);

		double[] pair = new double[2];
		double minDiff = Double.MAX_VALUE;
		for (int i = 0; i < a.length - 1; i++) {
			double diff = Math.abs(a[i] - a[i + 1]);
			if (diff < minDiff) {
				minDiff = diff;
				pair[0] = a[i];
				pair[1] = a[i + 1];
			}
		}

		return pair;
	}

}
