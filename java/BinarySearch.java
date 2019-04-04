/**
 * 
 * 二分查找
 *
 */
public class BinarySearch {

	public static int binarySearch(int key, int[] arr) {
		int low = 0;
		int high = arr.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] < key) {
				high = mid - 1;
			} else if (arr[mid] == key) {
				return mid;
			} else if (arr[mid] > key) {
				low = mid + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 3, 5, 7, 9, 12, 23, 45 };
		System.out.println(binarySearch(7, arr));
	}

}
