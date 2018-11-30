/*********************************************************************************
 * 1.4.17
 * 最遥远的一对（一维）。编写一个程序，给定一个含有N个double值得数组a[]，在其中找到一对
 * 最遥远的值：两者之差（绝对值）最大的两个数。程序在最坏情况下所需的运行时间应该是线性对数级别的
 * 
 *********************************************************************************/

package com.liwenwei.algs4.ex.chapter1;

import java.util.Arrays;

public class Ex_1_4_17_FarestPair {

	public static void main(String[] args) {
		double[] arr = { -20, -5, -3, 0, 1, 1, 6, 8 };
		System.out.println(Arrays.toString(findFarestDiffPair(arr)));
	}

	public static double[] findFarestDiffPair(double[] a) {
		Arrays.sort(a);
		
		double[] pair = new double[2];
		pair[0] = a[0];
		pair[1] = a[a.length - 1];

		return pair;
	}
}
