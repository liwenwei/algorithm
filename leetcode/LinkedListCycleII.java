/*****************************************************************
 * 142. Linked List Cycle II
 * 
 * 设：链表头是X，环的第一个节点是Y，slow和fast第一次的交点是Z。各段的长度分别是a,b,c，如图所示。环的长度是L
 * x         a       y
 * .---------------/ \
 *               /    \  b
 *             /       \ .z
 *             \        /
 *            c \      /
 *               \    /
 *                 ——
 * 方法一：
 * 第一次相遇后，让slow,fast继续走，记录到下次相遇时循环了几次。因为当fast第二次到达Z点时，
 * fast走了一圈，slow走了半圈，而当fast第三次到达Z点时，fast走了两圈，slow走了一圈，正好还在Z点相遇。
 * 
 * 方法二：
 * 第一次相遇后，让fast停着不走了，slow继续走，记录到下次相遇时循环了几次。
 * 
 * 方法三:
 * 第一次相遇时slow走过的距离：a+b，fast走过的距离：a+b+c+b
 * 因为fast的速度是slow的两倍，所以fast走的距离是slow的两倍，有 2(a+b) = a+b+c+b，可以得到a=c（这个结论很重要！）。
 * 
 * @author liwenwei
 * 
 ***************************************************************/

public class LinkedListCycleII {
	
	/**
	 * Floyd Cycle Detection Algorithm（Floyd判圈算法）
	 * 
	 * {@link https://zh.wikipedia.org/wiki/Floyd%E5%88%A4%E5%9C%88%E7%AE%97%E6%B3%95}
	 * 
	 * @param head
	 * @return
	 */
	public ListNode detectCycle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		// 如果存在环的话
		while (true) {
			if (fast == null || fast.next == null) {
				return null; // 遇到了null，说明不存在环
			}
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				break; // 第一次相遇
			}
		}
		
		// slow和fast第一次相遇时，第一次相遇时slow走过的距离：a+b，fast走过的距离：a+b+c+b，
		// 因为fast的速度是slow的两倍，所以fast走的距离是slow的两倍，有 2(a+b) = a+b+c+b，可以得到a=c
		// slow从头开始走，fast继续一步一步走，直到相遇在环的起始点
		slow = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		
		return slow;
	}
	
}
