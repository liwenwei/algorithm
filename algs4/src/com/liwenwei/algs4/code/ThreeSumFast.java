package com.liwenwei.algs4.code;

import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * ---------------------------------
 * 算法                            运行时间的增长数量级
 * ---------------------------------
 * TwoSum               N^2
 * TwoSumFast           NlgN
 * ThreeSum             N^3
 * ThreeSumFast         N^2lgN
 * ---------------------------------
 */
public class ThreeSumFast {

	public static int count(int[] a) {
		Arrays.sort(a);
		int N = a.length;
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				int k = Arrays.binarySearch(a, -(a[i] + a[j]));
				if (k > j) {
					cnt++;
				}
			}
		}
		return cnt;
	}

	public static void main(String[] args) {
		int[] a = In.readInts(args[0]);
		StdOut.println(count(a));
	}

}
