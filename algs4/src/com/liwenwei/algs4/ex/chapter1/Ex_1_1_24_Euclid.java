package com.liwenwei.algs4.ex.chapter1;

/**
 * Euclidean algorithm(欧几里德算法), 又称辗转相除法，是求最大公约数的算法
 * 
 * @author liwenwei
 *
 */
public class Ex_1_1_24_Euclid {

	public static void main(String[] args) {
		System.out.println(euclid(1111111, 1234567));
	}

	private static int euclid(int p, int q) {
		if (q == 0)
			return p;
		int r = p % q;
		return euclid(q, r);
	}

}
