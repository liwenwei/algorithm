package com.liwenwei.algs4.ex;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Ex_1_1_21 {

	private static void out() {
		if (!StdIn.isEmpty()) {
			String line = StdIn.readLine();
			String[] str = line.split(",");
			System.out.println(str[0] + str[1] + str[2]);
			int a = Integer.parseInt(str[1]);
			int b = Integer.parseInt(str[2]);
			out();
			StdOut.printf("%s:%d,%d,%f", str[0], a, b, ((double) a / b));
		}
	}

	public static void main(String[] args) {
		out();
	}
}
