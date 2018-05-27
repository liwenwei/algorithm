import java.util.Arrays;

public class sort {

	/**
	 * 冒泡排序
	 * 
	 * <p>
	 * 冒泡排序运作：
	 *  1. 比较相邻的元素。如果第一个比第二个大，就交换他们两个
	 *  2. 对每一对相邻元素做同样的工作，从开始第一对到结尾最后一对。这部做完后，最后的元素会是最大的数
	 *  3. 针对所有的元素重复以上的步骤，除了最后一个
	 *  4. 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
	 * 
	 * 总结： 每一次循环，都将最大的数排到最后的元素（像冒泡一样）
	 * </p>
	 * 
	 * @param arr
	 *            数组
	 */
	public static void bubbleSort(int[] arr) {
		int i, j, temp;
		for (i = 0; i < arr.length; i++) {
			for (j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}

	/**
	 * 插入排序
	 * 
	 * <P>
	 * 工作原理是通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
	 * </p>
	 * 
	 * @param arr
	 *            数组
	 */
	public static void insertionSort(int[] arr) {
		int i, j, temp;
		for (i = 0; i < arr.length - 1; i++) {
			for (j = i + 1; j > 0; j--) {
				if (arr[j - 1] < arr[j])
					break;
				temp = arr[j];
				arr[j] = arr[j - 1];
				arr[j - 1] = temp;
			}
		}
	}

	/**
	 * 选择排序
	 * 
	 * <P>
	 * 工作原理： 在未排序的序列中找到最小（最大）元素，存放到排序序列的起始位置，然后，
	 * 再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾
	 * </P>
	 * @param arr 数组
	 */
	public static void slectionSort(int[] arr) {
		int i, j, temp, min;
		for (i = 0; i < arr.length - 1; i++) {
			min = i;
			for (j = i + 1; j < arr.length; j++) {
				if (arr[min] > arr[j]) {
					min = j;
				}
				temp = arr[min];
				arr[min] = arr[i];
				arr[i] = temp;
			}
		}
	}
	
	/**
	 * 快速排序
	 * 
	 * <p>
	 * 快速排序使用分治法（Divide and conquer）策略来把一个序列（list）分为两个子序列（sub-lists）
	 * 步骤：
	 *   1. 从数列中挑出一个元素，称为基准（pivot）
	 *   2. 重新排序数列，所有比基准小的元素摆放在基准前面，所有比基准值大的元素排在基准后面（相同的数可以放到任何一边）。
	 *   在这个分区结束后，该基准就处于数列的中间位置，这个称为分区（partition）操作。
	 *   3. 递归地（recursively）把小于基准值的子数列和大于基准值的子数列排序。
	 * 
	 * How to pick the pivot?
	 *   1. Always pick first element as pivot
	 *   2. Always pick last element as pivot
	 *   3. Pick random element as pivot
	 *   4. Pick median as pivot (implemented below)
	 * 
	 * </p>
	 * 
	 * @param arr
	 */
	public static void quickSort(int[] arr, int left, int right) {
		int index = partition(arr, left, right);
		if (left < index - 1) {
			quickSort(arr, left, index - 1);
		}
		if (index < right) {
			quickSort(arr, index, right);
		}
	}

	private static int partition(int[] arr, int left, int right) {
		int i = left, j = right;
		int tmp;
		int pivot = arr[(left + right) / 2];

		while (i <= j) {
			while (arr[i] < pivot)
				i++;
			while (arr[j] > pivot)
				j--;
			if (i <= j) {
				tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
				i++;
				j--;
			}
		}
		return i;
	}

	private static void quickSortLastPivot(int[] arr, int low, int high) {
		if (low < high) {
			int pi = partitionLastPivot(arr, low, high);

			quickSortLastPivot(arr, low, pi - 1);
			quickSortLastPivot(arr, pi + 1, high);
		}
	}

	private static int partitionLastPivot(int[] arr, int low, int high) {
		int pivot = arr[high];
		int i = low - 1; // Index of smaller element
		for (int j = low; j < high; j++) {
			// If current element is smaller than or
			// equal to pivot
			if (arr[j] <= pivot) {
				i++; // increment index of smaller element

				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
			}
		}

		// swap arr[i+1] and arr[high] (or pivot)
		int temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;

		return i + 1;
	}
	
	/**
	 * <p>
	 * 是插入排序的一种更高效的改进版本
	 * </p>
	 * <p>
	 * 一个更好理解的希尔排序实现：将数组列在一个表中并对列排序（用插入排序）。重复这过程，不过每次用更长的列来进行。
	 * 最后整个表就只有一列了。将数组转换至表是为了更好地理解这算法
	 * </p>
	 * @param arr
	 */
	private static void shellSort(int[] arr) {
		int gap = 1, i, j, len = arr.length;
		int temp;
		while (gap < len / 3)
			gap = gap * 3 + 1;
		for (; gap > 0; gap /= 3) {
			for (i = gap; i < len; i++) {
				temp = arr[i];
				for (j = i - gap; j >= 0 && arr[j] > temp; j -= gap) {
					arr[j + gap] = arr[j];
				}
				arr[j + gap] = temp;
			}
		}
	}

	public static void main(String[] args) {
		int[] arr = { 6, 3, 1, 7, 5 };
		bubbleSort(arr);
		System.out.println("bubble sort:" + Arrays.toString(arr));

		int[] arr1 = { 6, 3, 1, 7, 5 };
		insertionSort(arr1);
		System.out.println("insertion sort:" + Arrays.toString(arr1));

		int[] arr2 = { 6, 3, 1, 7, 5 };
		selectionSort(arr2);
		System.out.println("selection sort:" + Arrays.toString(arr2));

		int[] arr3 = { 6, 3, 1, 7, 5 };
		quickSort(arr3, 0, arr3.length - 1);
		System.out.println("quick sort:" + Arrays.toString(arr3));

		int[] arr4 = { 6, 3, 1, 7, 5 };
		quickSortLastPivot(arr4, 0, arr4.length - 1);
		System.out.println("quick sort last pivot:" + Arrays.toString(arr4));
		
		int[] arr5 = { 6, 3, 1, 7, 5 };
		shellSort(arr5);
		System.out.println("shell sort:" + Arrays.toString(arr5));
	}
}
