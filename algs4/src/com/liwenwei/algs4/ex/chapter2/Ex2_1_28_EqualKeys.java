/*****************************************************************
 * 2.1.28 相等的主键， 一个数组的所有的元素只取两个值
 * 
 * @author liwenwei
 * 
 ****************************************************************/
package com.liwenwei.algs4.ex.chapter2;

import java.util.Arrays;

import com.liwenwei.algs4.code.Insertion;

public class Ex2_1_28_EqualKeys {

	public static void main(String[] args) {
		int[] oldArr = generateEqualKeys(30, 0, 1);
		Integer[] arr = new Integer[oldArr.length];
		for (int i = 0; i < arr.length; i++)
			arr[i] = oldArr[i];
			
		Insertion.sort(arr);
		
		System.out.println(Arrays.toString(arr));
	}
	
	public static int[] generateEqualKeys(int length, int key1, int key2) {
		int[] alternatives = new int[length];
		for (int i = 0; i < alternatives.length; i++) {
			alternatives[i] = getRandomAlternative(key1, key2);
		}
		return alternatives;
	}
	
	private static int getRandomAlternative(int key1, int key2) {
		// Math.random ~ [0, 1]区间
		return Math.random() < 0.5 ? key1 : key2;
	}
}
