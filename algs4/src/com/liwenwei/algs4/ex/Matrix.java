package com.liwenwei.algs4.ex;

public class Matrix {
	// 向量点乘
	public static double dot(double[] x, double[] y) {
		int val = 0;
		for (int i =0; i < x.length; i++) {
			val += x[i] * y[i];
		}
		return val;
	}
	
	// 矩阵和矩阵之积
	public static double[][] mult(double[][] a, double[][] b) {
		
	}
	
	// 转置矩阵
	public static double[][] transpose(double[][] a) {
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
	public static double[] mult(double[][] a, double[] x) {
		
	}
	
	// 向量和矩阵之积
	public static double[] mult(double[] y, double[][] a) {
		
	}
}
