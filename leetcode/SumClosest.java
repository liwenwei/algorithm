/*****************************************************************
 * 已知一个升序的数组array，再给定一个定值sum，现在要找出数组array中哪两个元素 的和最接近于这个
 * 定值sum，并输出这两个元素
 * 
 * @author liwenwei
 * 
 ****************************************************************/

public class SumClosest {

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		sumClosest(a, 15);
	}

	public static void sumClosest(int[] a, int sum) {
		int lt = 0;
		int rt = a.length - 1;
		while (lt < rt) {
			int val = a[lt] + a[rt];
			if (val == sum) {
				System.out.printf("%d - %d\n", a[lt], a[rt]);
				return;
			} else if (val > sum) {
				rt--;
			} else if (val < sum) {
				lt++;
			}
		}
	}
}
