/*****************************************************************
 * 141. Linked List Cycle
 * 
 * @author liwenwei
 * 
 ***************************************************************/

public class LinkedListCycle {
	
    public boolean hasCycle(ListNode head) {
    	if (head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        while(slow.next != null && fast.next != null && fast.next.next != null) {
        	slow = slow.next;
        	fast = fast.next.next;
        	if (slow.equals(fast)) {
        		return true;
        	}
        }
        return false;
    }
}
