package linkedlist;

/**
 * https://leetcode-cn.com/problems/linked-list-cycle/
 * 
 * @author michaelyang
 *
 */
public class _141_circleLinkedList {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public boolean hasCycle(ListNode head) {
		
		if (head == null || head.next == null) {
			return false;
		}
		
		ListNode fast = head.next;
		ListNode slow = head;
		
		while (fast != null && fast.next != null) {
			if (slow == fast) {
				return true;
			}
			slow = slow.next;
			fast = fast.next;
		}
		return false;
	}

}
