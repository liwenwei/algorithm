/*****************************************************************
 * 2.3.15 螺丝和螺帽
 * 
 * （G.J.E.Rawlins）假设有N个螺丝和N个螺帽混在一堆，你需要快速将它们配对。一个
 * 螺丝只会匹配一个螺帽，一个螺帽也只会匹配一个螺丝。你可以试着把一个螺丝和一个
 * 螺帽拧在一起看看谁大了，但不能直接比较两个螺丝或者两个螺帽。给出一个解决这个问题的有效方法。
 * 
 * @author liwenwei
 * 
 ****************************************************************/
package com.liwenwei.algs4.ex.chapter2;

import java.util.Arrays;

public class Ex2_3_15_NutsBolts {

	public static void main(String[] args) {
		int[] nuts = {7, 4, 1, 2, 5, 6, 9, 8, 3, 10};
		int[] bolts = {5, 7, 2, 4, 6, 3, 9, 8, 10, 1};
		
		Ex2_3_15_NutsBolts notsBolts = new Ex2_3_15_NutsBolts();
		notsBolts.match(nuts, bolts, 0, nuts.length - 1);
		System.out.println(Arrays.toString(nuts));
		System.out.println(Arrays.toString(bolts));
	}
	
	// 按照pivot切分数组arr
	private int partition(int[] arr, int pivot, int low, int high) {
		while (low < high) {
			while (low < high && arr[low] < pivot) low++;
			while (low < high && arr[high] > pivot) high--;
			if (low < high) swap(arr, low, high);
		}
		return low;
	}
	
	/**
	 * 基本思想使用快排的将小于pivot的数放在左边，大于pivot的数放在右边
	 * 1. 从nuts中取出第一个元素作为pivot，将bolts partition（切分）并且得到bolts中相应和pivot相等元素的index， 将bolts[index]放在最前面
	 * 2. 这时候nuts和bolts中第一元素相等
	 * 3. 从bolts中取出第二元素作为pivot，将nuts partition并且得到nuts中相应和pivot相等元素的index，将bolts[index]放在bolts第二元素
	 * 4. 这时候nuts和bolts中前两个元素一致
	 * 5. 从nuts中取出第三个个元素作为pivot
	 * ...
	 * 
	 * | nut1 | nut2 | 较小的螺帽 | 较大的螺帽 |
	 * | bolt1| bolt2| 较小的螺丝 | 较大的螺丝 |
	 * 
	 * @param nuts  螺帽
	 * @param bolts 螺丝
	 * @param low   最左边index
	 * @param high  最右边index
	 */
	public void match(int[] nuts, int[] bolts, int low, int high) {
		if (low >= high) return;
		
		// 将bolts按照nuts[low] partition
		int li = partition(bolts, nuts[low], low, high);
		// 将bolts中和pivot相等的元素i放在最左边low的位置
		swap(bolts, low, li);
		
		// 将bolts按照bolts[low + 1] partition
		int ri = partition(nuts, bolts[low + 1], low + 1, high);
		// 将nuts中和pivot相等的元素i放在最左边low+1的位置
		swap(nuts, low + 1, ri);
		
		match(nuts, bolts, low + 2, ri);
		match(nuts, bolts, ri + 1, high);
	}
	
	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
}
