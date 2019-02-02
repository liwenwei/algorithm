/****************************************************************************
 * 2.1.7 对于逆序数组，选择排序和插入排序谁更快？
 * 
 * 选择排序:
 * 比较次数： N+（N-1）+（N-2）+（N-3）+..+1
 * 交换次数： 1+1+1+1....+1 = N
 * 
 * 插入排序：
 * 比较次数： 1+2+3+4....+N
 * 交换次数： 1+2+3+4....+N
 * 
 * 综合上述，对于逆序数组，选择排序更快
 * 
 * @author liwenwei
 *
 ***************************************************************************/
package com.liwenwei.algs4.ex.chapter2;

import com.liwenwei.algs4.code.Insertion;
import com.liwenwei.algs4.code.Selection;
import com.liwenwei.algs4.code.Stopwatch;

public class Ex2_1_7_RunFastII {
	
	public static void main(String[] args) {
		Comparable[] arr1 = { 50, 49, 48, 47, 46, 45, 43, 42, 41, 40, 39, 38, 37, 36, 35, 34, 33, 32, 31, 30, 29, 28,
				26, 25, 24, 23, 22, 21, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		Stopwatch timer1 = new Stopwatch();
		Selection.sort(arr1);
		System.out.println(timer1.elapsedTime());
		
		Comparable[] arr2 = { 50, 49, 48, 47, 46, 45, 43, 42, 41, 40, 39, 38, 37, 36, 35, 34, 33, 32, 31, 30, 29, 28,
				26, 25, 24, 23, 22, 21, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		Stopwatch timer2 = new Stopwatch();
		Insertion.sort(arr2);
		System.out.println(timer2.elapsedTime());
		
	}
	
}
