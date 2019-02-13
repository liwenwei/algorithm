/*****************************************************************
 * 2.1.35 不均匀的概率分布
 * - 高斯分布
 * - 泊松分布
 * - 几何分布
 * - 离散分布
 * 
 * @author liwenwei
 * 
 ****************************************************************/
package com.liwenwei.algs4.ex.chapter2;

import java.util.Arrays;
import java.util.Random;

public class Ex2_1_35_NonuniformDistributions {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(generateGaussian(20)));
		System.out.println(Arrays.toString(generatePoisson(20)));
		System.out.println(Arrays.toString(generateGeometric(20)));
		System.out.println(Arrays.toString(generateDiscrete(20)));
	}
	
	/**
	 * 高斯分布（Gaussian）
	 * 
	 * @param length 数组长度
	 * @return 随机排列的高斯分布数组
	 */
	private static double[] generateGaussian(int length) {
		double[] arr = new double[length];
		Random random = new Random();
		for (int i = 0; i < arr.length; i++) {
			// TODO: 如何自定义算法产生正态分布（高斯分布）随机数
			arr[i] = random.nextGaussian();
		}
		return arr;
	}
	
	// 泊松分布
	private static int[] generatePoisson(int length) {
		int[] arr = new int[length];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = getRandomPoisson(30);
		}
		return arr;
	}
	
	// 参考：http://en.wikipedia.org/wiki/Poisson_distribution#Generating_Poisson-distributed_random_variables
	private static int getRandomPoisson(double lambda) {
		double L = Math.exp(-lambda);
		double k = 0, p = 1;
		do {
			k++;
			p*= Math.random();
		} while (p > L);
		return (int)(k - 1);
	}
	
	// 泊松分布
	private static int[] generateGeometric(int length) {
		int[] arr = new int[length];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = getRandomGeometric(30);
		}
		return arr;
	}
	
	// 什么是seed？seed顾名思义为种子，对于一个伪随机数生成器，只要seed相同，产生的随机数序列就是相同的
	// seed不同，循环产生的随机数序列则不同
	private static int getRandomGeometric(double seed) {
		double p = 1.0 / seed;
		return (int)(Math.ceil(Math.log(Math.random())/Math.log(1.0-p)));
	}
	
	private static int[] generateDiscrete(int length) {
		return Ex2_1_28_EqualKeys.generateEqualKeys(length, 0, 1);
	}
	
}
