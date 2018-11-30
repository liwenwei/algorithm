/********************************************   
 * java doubling ratio test result:
 * 
 *   250     0.0      1.0
 *   500     0.0      3.5
 *  1000     0.1      5.1
 *  2000     0.5      7.7
 *  4000     4.3      7.9
 *  8000    33.7      7.8
 * 16000   272.2      8.1
 * ...
 * 
 *******************************************/

package com.liwenwei.algs4.code;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * 
 * 倍率实验
 *
 */
public class DoublingRatio {
	private static final int MAXIMUM_INTEGER = 1000000;

	private DoublingRatio() {
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

	/**
	 * 在比例趋近于极限时， 只需要不断乘以该比例即可得到更大规模的问题的运行时间。
	 * 这里， 增长数量级的近似模型是一个幂次法则，指数为该比例的以2为底的对数
	 * 
	 * 这个实验中，比例的时间倍率的收敛值~8
	 * @param args
	 */
	public static void main(String[] args) {
		double prev = timeTrial(125);
		for (int n = 250; true; n += n) {
            double time = timeTrial(n);
            StdOut.printf("%7d %7.1f %8.1f\n", n, time, time/prev);
            prev = time;
        } 
	}
}
