/***************************************************************
 * 
 * % java DoublingTest result:
 *     250     0.0
 *     500     0.0
 *    1000     0.1
 *    2000     0.6
 *    4000     4.2
 *    8000    33.5
 * ...
 *    
 **************************************************************/

package com.liwenwei.algs4.code;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class DoublingTest {
	private static final int MAXIMUM_INTEGER = 1000000;

	private DoublingTest() {
	}

	public static double timeTrial(int n) {
		int[] a = new int[n];
		// Fake data
		for (int i = 0; i < a.length; i++) {
			a[i] = StdRandom.uniform(-MAXIMUM_INTEGER, MAXIMUM_INTEGER);
		}
		Stopwatch timer = new Stopwatch();
		ThreeSum.count(a);
		return timer.elapsedTime();
	}

	public static void main(String[] args) {
		for (int n = 250; true; n += n) {
            double time = timeTrial(n);
            StdOut.printf("%7d %7.1f\n", n, time);
        } 
	}

}
