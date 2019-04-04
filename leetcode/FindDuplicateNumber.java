/*****************************************************************
 * 287. Find the Duplicate Number
 * 
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), 
 * prove that at least one duplicate number must exist. Assume that there is only one duplicate number, 
 * find the duplicate one.
 * 
 * 分析：
 * 1. 如果一般的查找重复的数字，一般可以先排序，然后遍历数组即可，或者用counter统计出现次数，但由于题目要求O(1)的
 * 额外空间和 小于O(n^2)的时间复杂度，以及不能修改原始数组，因此都不可行
 * 2. 数组中只有一个重复的数字，这个问题就类似于有环的链表，数组中重复的数字类似于有环链表中环的起始点（相遇点），
 * 因此可以用Floyd Cycle Detection Algorithm（弗洛伊德判圈算法）来实现
 * 
 * 
 * @author liwenwei
 * 
 ***************************************************************/


public class FindDuplicateNumber {
	
	public static void main(String[] args) {
		int[] a = {3,1,3,4,2};
		FindDuplicateNumber f = new FindDuplicateNumber();
		System.out.println(f.findDuplicate(a));
	}
	
	/**
	 * 1. Convert array to circle linked list
	 * 2. Find circle start point
	 * 
	 * @param nums
	 * @return
	 */
    public int findDuplicate(int[] nums) {
    	if (nums.length > 1) {
    		int slow = nums[0];
            int fast = nums[nums[0]];
            while (slow != fast) {
            	slow = nums[slow];
            	fast = nums[nums[fast]];
            }
            
            slow = 0;
            while (slow != fast) {
            	slow = nums[slow];
            	fast = nums[fast];
            }
            return slow;
        }
    	return -1;
    }
	
}
