/***********************************************************************
 * 
 * 堆排序（heap sort)
 * 
 ***********************************************************************/
package sort;

import java.util.Arrays;

public class HeapSort {

	private int[] arr;

	public HeapSort(int[] arr) {
		this.arr = arr;
	}

	/**
	 * 堆排序的主要程序入口
	 */
	public void sort() {
		/*
		 * 第一步： 将数组堆化
		 * beginIndex = 第一个非叶子节点。
		 * 从第一个非叶子节点开始即可，无需从最后一个叶子节点开始。
		 * 叶子节点可以看作符合堆要求的节点，根节点就是它自己且自己一下值为最大
		 */
		int len = arr.length - 1;
		int beginIndex = (len - 1) >> 1;
		for (int i = beginIndex; i >= 0; i--) {
			maxHeapify(i, len);
		}

		/*
		 * 第二步： 对堆化数据进行排序 （最大堆， 有序区）
		 * - 每次把堆顶移除出来，放到有序区的末尾，然后重新调整堆
		 * 
		 * 每次都是移除最顶端根节点a[0]，与最尾部节点位置调换，同时遍历长度 -1
		 * 然后重新调整被换到根节点的末尾元素，使其符合堆的特性
		 * 直至未排序的堆长度为0
		 */
		for (int i = len; i > 0; i--) {
			swap(0, i);
			maxHeapify(0, i - 1);
		}
	}

	/**
	 * 堆化处理，调整index处的数据，使其符合最大堆的特性
	 * 
	 * 由下到上（求最大）： 叶子节点 -> 非叶子节点 -> 父节点 -> 根节点，先求出第一个非叶子节点的最大值 依次向上
	 * 
	 * @param index 需要堆化处理的索引值
	 * @param len 未排序的堆（数组）的长度
	 */
	private void maxHeapify(int index, int len) {
		int li = (index << 1) + 1;  // 左子节点索引
		int ri = li + 1;            // 右子节点索引
		int cMax = li;              // 子节点值最大索引，默认左子节点

		if (li > len || ri > len)
			return;
		if (arr[ri] > arr[li]) // 先判断左右子节点哪个比较大，获取最大子节点索引cMax
			cMax = ri;

		if (arr[cMax] > arr[index]) {
			swap(cMax, index);      // 如果子节点最大值大于父节点值，就调换父节点和最大子节点
			maxHeapify(cMax, len);  // 继续判断换下后的父节点是否符合最大堆的特性
		}
	}

	private void swap(int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		int[] arr = { 8, 4, 5, 6, 1, 1, 10 };
		new HeapSort(arr).sort();
		System.out.println(Arrays.toString(arr));
	}
}
