/*****************************************************************
 * Kendall Tau Distance
 * 
 * @author liwenwei
 * 
***************************************************************/

import java.util.Arrays;

public class KendallTauDistance {

	public static void main(String[] args) {
		int[] a = new int[] { 0, 3, 1, 6, 2, 5, 4 };
		int[] b = new int[] { 1, 0, 3, 6, 4, 2, 5 };
		int[] aIndex = new int[a.length];
		int[] bIndex = new int[b.length];
		for (int i = 0; i < a.length; i++) {
			aIndex[a[i]] = i;
		}
		for (int i = 0; i < b.length; i++) {
			bIndex[i] = aIndex[b[i]];
		}
		System.out.println(Arrays.toString(aIndex));
		System.out.println(Arrays.toString(bIndex));
	}

}
