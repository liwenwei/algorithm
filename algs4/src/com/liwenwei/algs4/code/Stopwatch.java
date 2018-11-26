package com.liwenwei.algs4.code;

import edu.princeton.cs.algs4.StdOut;

public class Stopwatch {
	
	private final long start;
	
	public Stopwatch() {
		start = System.currentTimeMillis();
	}
	
	/**
	 * Return the elapsed CPU time (in seconds) since the stopwatch was created
	 * 
	 * @return the elapsed CPU time
	 */
	public double elapsedTime() {
		long now = System.currentTimeMillis();
		return (now - start) / 1000.0;
	}
	
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		
		Stopwatch stopwatch1 =  new Stopwatch();
		double sum1 = 0.0;
        for (int i = 1; i <= n; i++) {
            sum1 += Math.sqrt(i);
        }
        double time1 = stopwatch1.elapsedTime();
        StdOut.printf("%e (%.2f seconds)\n", sum1, time1);
        
        Stopwatch stopwatch2 =  new Stopwatch();
        double sum2 = 0.0;
        for (int i = 1; i <= n; i++) {
            sum2 += Math.pow(i, 0.5);
        }
        double time2 = stopwatch2.elapsedTime();
        StdOut.printf("%e (%.2f seconds)\n", sum2, time2);
	}
	
}
