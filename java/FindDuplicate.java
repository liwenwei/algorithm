import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;

/*****************************************************************
 * <p>Find a duplicate in an array</p>
 * 
 * Given an array of n + 1 integers between 1 and n, find one of the duplicates.
 * If there are multiple possible answers, return one of the duplicates.
 * If there is no duplicate, return -1.
 * Example:
 * Input: [1, 2, 2, 3]
 * Output: 2
 * Input: [3, 4, 1, 4, 1]
 * Output: 4 or 1
 * 
 * {@link https://medium.com/solvingalgo/solving-algorithmic-problems-find-a-duplicate-in-an-array-3d9edad5ad41}
 * 
 * @author liwenwei
 * 
***************************************************************/

public class FindDuplicate {
	
	public static void main(String[] args) {
		int[] arr = {3, 4, 1, 4, 1};
		System.out.println(duplicateI(arr));
		System.out.println(duplicateIIArray(arr));
		System.out.println(duplicateIIHashTable(arr));
		System.out.println(duplicateIII(arr));
		
		int[] arr1 = {1, 4, 3, 3, 2, 5};
		System.out.println(duplicateIIII(arr1));
	}
	
	/**
	 * Brute Force
	 * Time Complexity = O(n^2)
	 * space complexity = O(1)
	 * 
	 * @param arr
	 * @return
	 */
	public static boolean duplicateI(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] == arr[j])
					return true;
			}
		}
		return false;
	}
	
	/**
	 * Count Iterations
	 * 
	 * <p>
	 * To have a data structure to count the number of iterations for each integer.
	 * This solution could be implemented either with an array or a hash table
	 * </p>
	 * 
	 * @param arr
	 * @return
	 */
	public static boolean duplicateIIArray(int[] arr) {
		int[] counter = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			// only work when each element is between 1 and n
			counter[arr[i]]++;
			if (counter[arr[i]] > 1) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean duplicateIIHashTable(int[] arr) {
		Hashtable<Integer, Integer> counter = new Hashtable<>();
		for (int i = 0; i < arr.length; i++) {
			if (counter.containsKey(arr[i])) {
				return true;
			} else {
				counter.put(arr[i], 1);
			}
		}
		return false;
	}
	
	/**
	 * Sorted Array
	 * 
	 * In this case, we would just have to compare each element with its right neighbor
	 * 
	 * @param arr
	 * @return
	 */
	public static boolean duplicateIII(int[] arr) {
		Arrays.sort(arr);
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] == arr[i + 1]) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Sum of the elements
	 * 
	 * A direction we may think about is to sum the elements of the array and to compare it
	 * with 1 + 2 + .. + n
	 * 
	 * For example:
	 * Input: [1, 4, 3, 3, 2, 5]
	 * Sum = 18
	 * As in this example, we have n = 5
	 * Sum of 1 to 5 = ((1+5)*5)/2 = 15
	 * => 18 - 15 = 3, so 3 is the duplicate
	 * 
	 * This case only work we have one duplicate
	 * 
	 * 
	 * @param arr
	 * @return
	 */
	public static int duplicateIIII(int[] arr) {
		int n = arr.length;
		int sumContinuous = ((n + 1) * n) / 2;
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		return Math.abs(sumContinuous - sum) ;
	}
}
