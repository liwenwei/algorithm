/*****************************************************************
 * 217. Contains Duplicate
 * 
 * @author liwenwei
 * 
 ***************************************************************/

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

	public static void main(String[] args) {
		int[] a = { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 };
		ContainsDuplicate cd = new ContainsDuplicate();
		System.out.println(cd.containsDuplicate(a));
	}

	public boolean containsDuplicate(int[] nums) {
		Set<Integer> distinct = new HashSet<Integer>();
		for (int num : nums) {
			if (distinct.contains(num)) {
				return true;
			}
			distinct.add(num);
		}
		return false;
	}

}
