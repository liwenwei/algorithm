/*****************************************************************
 * 将数组第一个元素作为基准数（pivot），小于pivot的数放在pivot左边，大于pivot的数放在pivot
 * 右边
 * 
 * @author liwenwei
 * 
***************************************************************/

import java.util.Arrays;

public class Pivot {

	public static void main(String[] args) {
		Pivot pivot = new Pivot();
		
		int[] arr1 = {7, 3, 6, 1, 8, 9, 2, 4};
		System.out.println(Arrays.toString(arr1));
		pivot.merge(arr1);
		System.out.println(Arrays.toString(arr1));
	}
	
	public void merge(int[] arr) {
		if (arr == null || arr.length < 2)
			return;
		int pivot = arr[0];
		int i = 0, j = arr.length; // 左右扫描指针
		while (true) {
			while (arr[++i] < pivot) {
				if (i == arr.length - 1)
					break;
			}
			while (arr[--j] > pivot) {
				if (j == 0)
					break;
			}
			
			if (i >= j) break;
			swap(arr, i, j);
		}
		swap(arr, 0, j); // 将pivot放入正确的位置
	}
	
	private void swap(int[] arr, int i, int j) {
		// Swap i and j
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
}
