package linkedlist;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list/
 * @author michaelyang
 *
 */
public class _206_reverseLinkedlist {
	
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode reverseList(ListNode head) {
		ListNode newHead = null;
		while (head != null) {
			ListNode temp = head.next;
			head.next = newHead;
			newHead = head;
			head = temp;
		}
		return newHead;
	}
}
