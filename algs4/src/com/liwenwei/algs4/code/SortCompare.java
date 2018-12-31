package com.liwenwei.algs4.code;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class SortCompare {
	
	public static double time(String alg, Comparable[] a) {
		Stopwatch timer = new Stopwatch();
		if (alg.equals("Insertion")) {
			Insertion.sort(a);
		} else if (alg.equals("Selection")) {
			Selection.sort(a);
		}
		return timer.elapsedTime();
	}
	
	/**
	 * 使用算法将T个长度为N的数组排序
	 * 
	 * @param alg
	 * @param N
	 * @param T
	 */
	public static double timeRandomInput(String alg, int N, int T) {
		double total = 0.0;
		Double[] a = new Double[N];
		for (int i = 0; i < T; i++) {
			for (int j = 0; j < N; j++)
				a[i] = StdRandom.uniform();
			total += time(alg, a);
		}
		return total;
	}
	
	public static void main(String[] args) {
		String alg1 = args[0];
		String alg2 = args[1];
		int N = Integer.parseInt(args[2]);
		int T = Integer.parseInt(args[3]);
		double t1 = timeRandomInput(alg1, N, T);
		double t2 = timeRandomInput(alg2, N, T);
		StdOut.printf("For %d random Doubles\n    %s is", N, alg1);
		StdOut.printf(" %.1f times faster than %s\n", t2/t1, alg2);
	}
	
}
