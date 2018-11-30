/****************************************
 * 1.4.8 编写一个程序，计算输入文件中相等的整数对的数量。如果你的第一个程序是平方级别的
 * 请继续思考并用Array.sort()给出一个线性对数界别的解答
 * 
 * 这个算法类似投票算法：选择绝对众数
 * http://www.liwenwei.com/2017/04/10/%E6%8A%95%E7%A5%A8%E7%AE%97%E6%B3%95%EF%BC%9A%E9%80%89%E6%8B%A9%E7%BB%9D%E5%AF%B9%E4%BC%97%E6%95%B0/
 * 
 ***************************************/
package com.liwenwei.algs4.ex.chapter1;

import java.util.Arrays;

public class Ex_1_4_8_Pairs {

	public static void main(String[] args) {
		// Tests
		int[] values1 = { 1, 2, 4, 1, 2, 1, 2, 4, 5, 1, 2, 4, 5, 1, 2, 5, 6, 7, 7, 8, 2, 1, 2, 4, 5 };
		System.out.println("countEqualNumberPair: " + countEqualNumberPair(values1) + " Expected: 49");
		System.out.println("countEqualNumberPair1: " + countEqualNumberPair1(values1) + " Expected: 49");
	}

	// O(N)
	// Arrays.sort()
	//
	// 从n个元素中取出k个元素，k个元素的组合数量为：
	// C(k, n) = (n k) = P(k, n)! / k! = n! / k!(n - k)!
	public static int countEqualNumberPair(int[] a) {
		Arrays.sort(a);

		int cnt = 0;
		int frequency = 1;
		for (int i = 1; i < a.length; i++) {
			if (a[i - 1] == a[i]) {
				frequency++;
			} else {
				if (frequency > 1) {
					cnt += frequency * (frequency - 1) / 2; // Arrangement formula
					frequency = 1;
				}
			}
		}

		if (frequency > 1) {
			cnt += frequency * (frequency - 1) / 2;
		}

		return cnt;
	}

	// O(N^2)
	public static int countEqualNumberPair1(int[] a) {
		int cnt = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] == a[j]) {
					cnt++;
				}
			}
		}
		return cnt;
	}
}
