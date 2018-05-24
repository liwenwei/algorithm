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
	 * @param arr 数组
	 */
	public static void bubbleSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] arr = {6, 3, 1, 7, 5};
		bubbleSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
