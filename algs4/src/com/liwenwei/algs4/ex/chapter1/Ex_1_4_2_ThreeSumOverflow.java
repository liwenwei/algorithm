/**********************************************
 * 
 * 修改 ThreeSum，正确处理两个较大的 int 值相加可能溢出的情况
 * 
 *********************************************/
package com.liwenwei.algs4.ex.chapter1;

import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Ex_1_4_2_ThreeSumOverflow {
	public static int count(int[] a) {
		int cnt = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				for (int k = j + 1; k < a.length; k++) {
					int sum = checkedAdd(checkedAdd(a[i], a[j]), a[k]);
					if (sum == 0) {
						cnt++;
					}
				}
			}
		}
		return cnt;
	}

	/**
	 * Add and check the sum of two integer is overflow or not
	 * 
	 * @param x
	 *            Integer
	 * @param y
	 *            Integer
	 * @return sum
	 */
	public static int checkedAdd(int x, int y) {
		long s = (long) x + (long) y;
		if (s < Integer.MIN_VALUE || s > Integer.MAX_VALUE) {
			throw new NoSuchElementException(String.format("OVERFLOW IN ADDITION %d + %d", x, y));
		}
		return (int) s;
	}

	public static void main(String[] args) {
		int[] a = In.readInts(args[0]);
		StdOut.println(count(a));
	}
}
