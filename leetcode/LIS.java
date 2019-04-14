/*****************************************************************
 * 300.Longest Increasing Subsequence(最长递增子序列)
 * 
 * Given an unsorted array of integers, find the length of longest 
 * increasing subsequence.
 * 
 * @author liwenwei
 * 
 ****************************************************************/

import java.util.Arrays;

public class LIS {
	
	public static void main(String[] args) {
		int[] a = {10, 9, 2, 5, 3, 7, 101, 18};
		LIS lis = new LIS();
		System.out.println(lis.lengthOfLIS(a));
		System.out.println(lis.lengthOfLISII(a));
		System.out.println(lis.lengthOfLISIII(a));
	}
	
	/**
	 * Brute Force。
	 * Time Complexity: O(n)=n^2
	 * 
	 * 首先来看一种动态规划Dynamic Programming的解法，我们维护一个一维dp数组，其中dp[i]表示以nums[i]为结尾的最长递增子串的长度，对于每一个nums[i]，
	 * 我们从第一个数再搜索到i，如果发现某个数小于nums[i]，我们更新dp[i]，更新方法为dp[i] = max(dp[i], dp[j] + 1)，
	 * 即比较当前dp[i]的值和那个小于num[i]的数的dp值加1的大小，我们就这样不断的更新dp数组，到最后dp数组中最大的值就是我们要返回的LIS的长度
	 * 
	 * @param nums 数组
	 * @return 最长递增序列长度
	 */
	public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int lis = 0;
        for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			lis = Math.max(lis, dp[i]);
		}
        return lis;
    }
	
	/**
	 *
	 * <p>思路是，我们先建立一个数组ends，把首元素放进去，然后比较之后的元素，如果遍历到的新元素比ends数组中的首元素小的话，
	 * 替换首元素为此新元素，如果遍历到的新元素比ends数组中的末尾元素还大的话，将此新元素添加到ends数组末尾(注意不覆盖原末尾元素)。
	 * 如果遍历到的新元素比ends数组首元素大，比尾元素小时，此时用二分查找法找到第一个不小于此新元素的位置，覆盖掉位置的原来的数字，
	 * 以此类推直至遍历完整个nums数组，此时ends数组的长度就是我们要求的LIS的长度，</p>
	 * 
	 * <p>特别注意的是ends数组的值可能不是一个真实的LIS，比如若输入数组nums为{4, 2， 4， 5， 3， 7}，那么算完后的ends数组为{2， 3， 5， 7}，
	 * 可以发现它不是一个原数组的LIS，只是长度相等而已</p>
	 * 
	 * @param nums 数组
	 * @return 最长递增序列长度
	 */
	public int lengthOfLISII(int[] nums) {
		int[] ends = new int[nums.length];
		ends[0] = nums[0];
		int n = 1;
		for(int num : nums) {
			if (num < ends[0]) {
				ends[0] = num;
			} else if (num > ends[n]) {
				ends[++n] = num;
			} else if (num > ends[0] && num < ends[n]) {
				// Binary Search
				int left = 0, right = n;
				while (left < right) {
					int mid = left + (right - left) / 2;
					if (ends[mid] < num) left = mid + 1;
					else right = mid;
				}
				ends[right] = num;
			}
		}
		return n;
    }
	
	/**
	 * 一种思路更清晰的二分查找法，跟上面那种方法很类似，思路是先建立一个空的dp数组，然后开始遍历原数组，对于每一个遍历到的数字，
	 * 我们用二分查找法在dp数组找第一个不小于它的数字，如果这个数字不存在，那么直接在dp数组后面加上遍历到的数字，如果存在，
	 * 则将这个数字更新为当前遍历到的数字，最后返回dp数字的长度即可，注意的是，跟上面的方法一样，特别注意的是dp数组的值可能不是一个真实的LIS
	 * 
	 * @param nums 数组
	 * @return 最长递增序列长度
	 */
	public int lengthOfLISIII(int[] nums) {
		int[] ends = new int[nums.length];
		int len = 0;
		for (int i = 0; i < nums.length; ++i) {
			int left = 0, right = len;
			while (left < right) {
				int mid  = left + (right - left) / 2;
				if (ends[mid] < nums[i]) left = mid + 1;
				else right = mid;
			}
			if (right >= len) ends[len++] = nums[i];
			else ends[right] = nums[i];
		}
		return len;
    }
	
}
