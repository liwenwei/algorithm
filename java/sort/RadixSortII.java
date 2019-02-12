/***********************************************************************
 * 基数排序的基本实现是通过[10 * N]的二维数组来维护N个桶，但实际数组只有N，二维数组过于稀疏，
 * 数组使用率为10%。所以优化的方法就是压缩辅助数组空间。这里用到了两个辅助数组count[10]和bucket[N].
 * - count[]是当前位（0~9）的桶中有几个元素， 当前digit每个元素的实际位置（或者最后一个元素的位置），
 * 根据 count[digit]-1 就能推断出当前位为digit的元素在桶中的position
 * 例如 count = {0， 1， 2， 2， 2， 4， 4， 5， 6， 7， 7}， 对应的digit位{0， 1， 2， 3， 4， 5， 6， 7， 8， 9,}，
 * 位为0的桶元素个数为0，
 * 位为1的桶中元素个数为1-0，最后一个元素在arr的position应为1
 * 位为2的桶中元素个数为2-1，最后一个元素在arr的position应为2
 * 位为3的桶中元素个数为2-2
 * 位为4的桶中元素个数为2-2
 * 位为5的桶中元素个数为4-2， 最后一个元素arr的position应为4
 * 位为6的桶中元素个数为5-4， 最后一个元素arr的position应为5
 * 依次类推
 * 
 * - bucket[]是从最低位到最高位每次排序的结果
 * 
 * @author liwenwei
 *
 ***********************************************************************/
package sort;

import java.util.Arrays;


public class RadixSortII {
	
	/**
	 * 获取当前数组的最大值
	 * @param arr 数组
	 * @return 数组最大值
	 */
	private static int getMax(int[] arr) {
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			if (max < arr[i])
				max = arr[i];
		}
		return max;
	}

	/**
	 * 
	 * @param arr 数组
	 * @param radix 基数，由于LSD从低位到高位排序，所以radix依次为1, 10, 100, 1000， 10000 ……
	 */
	private static void countSort(int[] arr, int radix) {
		int n = arr.length;
		int[] count = new int[10]; // 当前位为digit（0~9）的元素个数
		int[] bucket = new int[n]; // 桶
		Arrays.fill(count, 0); // 每次将count全部清零

		// 每个位（0~9）出现的次数
		for (int i = 0; i < n; i++) {
			count[(arr[i] / radix) % 10]++;
		}

		// 将count[i]和count[i-1]相加，这样就能获取每个digit出现的元素次数，以及最后元素在arr的position，
		// 实际上就是每个digit桶中每个元素的位置
		// 很有趣的数据压缩设计，可以深入了解一下
		for (int i = 1; i < 10; i++) {
			count[i] += count[i - 1];
		}

		for (int i = n - 1; i >= 0; i--) {
			// 将arr[i]依次放在bucket中, 并将该digit桶的元素个数-1
			bucket[count[(arr[i] / radix) % 10] - 1] = arr[i];
			count[(arr[i] / radix) % 10]--;
		}

		// Copy bucket to arr
		for (int i = 0; i < n; i++) {
			arr[i] = bucket[i];
		}
	}

	public static void radixSort(int[] arr) {
		int max = getMax(arr);

		// 根据最大值算出一共有多少位，即桶排序的次数
		for (int radix = 1; max / radix > 0; radix *= 10) {
			countSort(arr, radix);
		}
	}

	// A utility function to print an array
	private static void print(int[] arr, int n) {
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	/* Driver function to check for above function */
	public static void main(String[] args) {
		int arr[] = { 170, 45, 75, 90, 802, 24, 2, 66 };
		int n = arr.length;
		radixSort(arr);
		print(arr, n);
	}
}
