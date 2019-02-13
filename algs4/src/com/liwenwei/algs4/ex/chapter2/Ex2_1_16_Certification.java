/*****************************************************************
 * 2.1.16 验证。编写一个Check()方法．调用sort()对任惫数组排序。如果排序成功
 * 而且数组中的所有元素和原始的数组一直则返回true，否则返回false。不要假设sort()
 * 只能通过exch(）来移动 数据，可以信任并使用Arrays.sort()
 * 
 * @author liwenwei
 * 
 ****************************************************************/
package com.liwenwei.algs4.ex.chapter2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Ex2_1_16_Certification {

	public static void main(String[] args) {
		Comparable[] array = { 2, 20, -1, -30, 30, 5, 6, 8, -99, -3, 0, 4, 4, 4 };
		System.out.println("Check: " + check(array));
		System.out.println("Expected: true");
	}

	private static boolean check(Comparable[] arr) {

		// Map<Value, Count>
		Map<Comparable, Integer> mapVals = new HashMap<>();

		// Count all the values
		for (Comparable val : arr) {
			if (mapVals.containsKey(val)) {
				mapVals.put(val, mapVals.get(val) + 1);
			} else {
				mapVals.put(val, 1);
			}
		}

		Arrays.sort(arr);

		// Check if sort in order
		for (int i = 1; i < arr.length; i++) {
			if (arr[i].compareTo(arr[i - 1]) < 0)
				return false;
		}

		// if leave same set of objects as the origin array before sort
		for (Comparable val : arr) {
			if (mapVals.containsKey(val)) {
				int count = mapVals.get(val);
				if (count > 1) {
					count--;
					mapVals.put(val, count);
				} else {
					mapVals.remove(val);
				}
			} else {
				mapVals.put(val, 1);
			}
		}

		if (!mapVals.isEmpty()) {
			return false;
		}

		return true;
	}

}
