/******************************************************************
 * 
 * 证明从N数种取三个整数的不同组合的总数为N(N-1)(N-2)/6。 提示：使用数学归纳法
 * 
 * @author liwenwei
 *
 ******************************************************************/

package com.liwenwei.algs4.ex.chapter1;

public class Ex_1_4_1_MathematicalInduction {
	
	public static void main(String[] args) {
		System.out.println(countThreeCombinations(3));
		System.out.println(countThreeCombinations(4));
		System.out.println(countThreeCombinations(5));
		System.out.println(countThreeCombinations(6));
		System.out.println(countThreeCombinations(7));
		System.out.println(countThreeCombinations(8));
		System.out.println(countThreeCombinations(9));
		System.out.println(countThreeCombinations(10));
	}
	
	/**
	 * 直接根据组合公式:
	 * 从n个元素中取出k个元素，k个元素的组合数量为：
	 * C(k, n) = (n  k) = P(k, n)! / k! =  n! / k!(n - k)!
	 * 
	 * 根据公式推导出：
	 * k=3
	 * C(k, n) = n! / 3!(n-3)! = n(n-1)(n-2)/6
	 * 
	 * @param N
	 * @return
	 */
	public static int countThreeCombinations(int N) { 
		return N * (N - 1) * (N - 2) / 6;
	}
	
	/**
	 * 错误
	 * 
	 * N >= 3
	 * 当N=3， count=1
	 * 当N=4， count=3
	 * 当N=5， count=6
	 * 当N=6， count=10
	 * 当N=7， count=15
	 * 当N=8， count=21
	 * ……
	 * 
	 * 推导过程：
	 * N      1  2  3  4  5  6   7   8
	 * count  0  0  1  3  6  10  15  21
	 *               +2 +3 +4  +5  +6
	 * 
	 * 根据数学归纳法推论出公式：
	 * f(N)=0            if N<3
	 * f(N)=1            if N=3
	 * f(N)=f(N-1)+(N-2) if N>3
	 * 
	 * 使用递归实现
	 * 
	 * @param N
	 * @return
	 */
	public static int derivation(int N) {
		if (N < 3) {
			return 0;
		} else if (N == 3) {
			return 1;
		} else {
			return derivation(N - 1) + N - 2;
		}
	}
}
