/*****************************************************************
 * 219. Contains Duplicate II
 * 
 * 给定一个数组nums和一个整数k，是否存在两个不相等的整数 i 和 j，使得nums[i] == nums[j]，
 * 并且i和j之间的距离最多为k。
 * 
 * @author liwenwei
 * 
 ***************************************************************/

import java.util.HashMap;

public class ContainsDuplicateII {
	public static void main(String[] args) {
		int[] a = {1, 2, 3, 1};
		ContainsDuplicateII cd = new ContainsDuplicateII();
		System.out.println(cd.containsNearbyDuplicate(a, 3));
	}

	public boolean containsNearbyDuplicate(int[] nums, int k) {
		HashMap<Integer, Integer> distinct = new HashMap();
		for (int i = 0; i < nums.length; i++) {
			if (distinct.containsKey(nums[i])) {
				if (i - distinct.get(nums[i]) <= k) return true;
			}
			distinct.put(nums[i], i);
		}
		return false;
	}
}
