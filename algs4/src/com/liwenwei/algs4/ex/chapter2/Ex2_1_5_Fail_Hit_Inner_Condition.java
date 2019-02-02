/*****************************************************************
 * 2.1.5 构造一个含有N个元素的数组，是插入排序运行过程中的内循环的两个判断结果总是false
 * 
 * @author liwenwei
 * 
 ****************************************************************/
package com.liwenwei.algs4.ex.chapter2;

import com.liwenwei.algs4.code.Insertion;

public class Ex2_1_5_Fail_Hit_Inner_Condition {
	
	private static void main(String[] args) {
		Comparable[] arr = {1, 2, 4, 5};
		Insertion.sort(arr);
	}
	
}
