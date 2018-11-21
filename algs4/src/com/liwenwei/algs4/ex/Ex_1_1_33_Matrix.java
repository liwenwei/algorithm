package com.liwenwei.algs4.ex;

import edu.princeton.cs.algs4.StdOut; 

//矩阵库
public class Ex_1_1_33_Matrix {
	
	public static void main(String[] args) {
		//Vector dot product
		double[] x = {2.0, 3.0, 4.0};
		double[] y = {3.0, 2.0, 5.5};
		
		StdOut.println("Dot: " + dot(x,y));
		
		//Matrix-matrix product
		double[][] a = {
				{1, 2}
			};
		double[][] b = {
				{2, 3, 4},
				{2, 3, 4}
			};
		double[][] c = mult(a, b);
		
		StdOut.println("Matrix multiplication:");
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c[0].length; j++) {
				StdOut.print(c[i][j] + " ");
			}
			StdOut.println();
		}
		
		//Transpose
		double[][] d = {
				{1, 2, 3},
				{4, 5, 6}
			};
		
		double[][] e = transpose(d);
		
		StdOut.println("Transpose:");
		for (int i = 0; i < e.length; i++) {
			for (int j = 0; j < e[0].length; j++) {
				StdOut.print(e[i][j] + " ");
			}
			StdOut.println();
		}
		
		//Matrix-vector product
		double[][] f = {
				{1, 2, 3},
				{4, 5, 6}
			};
		
		double[] g = {1, 2, 3};
		
		double[] h = mult(f, g);
		
		StdOut.println("Matrix-vector product:");
		for (int i = 0; i < h.length; i++) {
			StdOut.print(h[i] + " ");
		}
		
		StdOut.println();
		//Vector-matrix product
		double[] i = {1, 2, 3};
		
		double[][] j = {
				{1, 2, 3},
				{4, 5, 6},
				{1, 2, 3}
			};

		double[] k = mult(i, j);
		
		StdOut.println("Vector-matrix product:");
		for (int l = 0; l < k.length; l++) {
			StdOut.print(k[l] + " ");
		}
	}
	
	// 向量点乘
	private static double dot(double[] x, double[] y) {
		if (x == null || y == null || x.length != y.length) {
			throw new IllegalArgumentException();
		}

		double val = 0;
		for (int i = 0; i < x.length; i++) {
			val += x[i] * y[i];
		}
		return val;
	}

	// 矩阵和矩阵之积
	// A(n*m) * B(m*p) = C(n*p)
	// C(ij) = A(i1)B(1j) + ... + A(im)B(mj) = Sum(A(ik) + B(kj)), k = 1 ~ m
	private static double[][] mult(double[][] a, double[][] b) {
		if (a == null || b == null || a.length == 0 || b.length == 0 || a[0].length != b.length) {
			throw new IllegalArgumentException();
		}

		int n = a.length;
		int m = b.length;
		int p = b[0].length;
		double[][] c = new double[n][p];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < p; j++) {
				double sum = 0;
				for (int k = 0; k < m; k++) {
					sum += a[i][k] + b[k][j];
				}
				c[i][j] = sum;
			}
		}
		return c;
	}

	// 转置矩阵
	private static double[][] transpose(double[][] a) {
		if (a == null) {
			throw new IllegalArgumentException();
		}

		if (a.length == 0) {
			return a;
		}

		int row = a[0].length;
		int column = a.length;
		double[][] arr = new double[row][column];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				arr[i][j] = a[j][i];
			}
		}
		return arr;
	}

	// 矩阵和向量之积
	// 矩阵*x向量
	private static double[] mult(double[][] a, double[] x) {

		if (a == null || x == null || a[0].length != x.length) {
			throw new IllegalArgumentException();
		}

		double[] b = new double[a.length];
		for (int i = 0; i < a.length; i++) {
			double sum = 0;
			for (int j = 0; j < a[0].length; j++) {
				sum += a[i][j] + x[j];
			}
			b[i] = sum;
		}
		return b;
	}

	// 向量和矩阵之积
	// 矩阵*y向量
	private static double[] mult(double[] y, double[][] a) {
		// Number of rows in matrix must be the same as the number of rows in vector
		if (a == null || y == null || a.length != y.length) {
			throw new IllegalArgumentException();
		}

		double[] b = new double[a[0].length];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				b[i] += a[j][i] * y[j];
			}
		}

		return b;
	}
}
