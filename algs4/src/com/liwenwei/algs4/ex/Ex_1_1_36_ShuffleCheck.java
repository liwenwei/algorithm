package com.liwenwei.algs4.ex;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Ex_1_1_36_ShuffleCheck {

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int m = Integer.parseInt(args[1]);

		int[][] position = new int[m][m];

		double[] arr = new double[m];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}

		for (int i = 0; i < n; i++) {
			shuffle(arr);
			for (int j = 0; j < arr.length; j++) {
				position[j][(int)arr[j]]++;
			}
		}

		printTable(position);
		// Entities close to N/M
	}

	private static void shuffle(double[] a) {
		int n = a.length;

		for (int i = 0; i < n; i++) {
			int r = i + StdRandom.uniform(n - i);
			double temp = a[i];
			a[i] = a[r];
			a[r] = temp;
		}
	}

	private static void printTable(int[][] positions) {
		for (int i = 0; i < positions.length; i++) {
			StdOut.printf("%3d  ", i);
			for (int j = 0; j < positions[0].length; j++) {
				StdOut.printf("%4d ", positions[i][j]);
			}
			StdOut.println();
		}
	}
}
