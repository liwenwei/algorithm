package com.liwenwei.algs4.ex;

public class Matrix {
	// �������
	public static double dot(double[] x, double[] y) {
		int val = 0;
		for (int i =0; i < x.length; i++) {
			val += x[i] * y[i];
		}
		return val;
	}
	
	// ����;���֮��
	public static double[][] mult(double[][] a, double[][] b) {
		
	}
	
	// ת�þ���
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
	
	// ���������֮��
	public static double[] mult(double[][] a, double[] x) {
		
	}
	
	// �����;���֮��
	public static double[] mult(double[] y, double[][] a) {
		
	}
}
