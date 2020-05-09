package 链表;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list/
 * @author michaelyang
 *
 */
public class _206_反转链表 {
	
	/**
	 * 递归的方式实现
	 * @param head
	 * @return
	 */
	public ListNode reverseLinkedList(ListNode head) {
		if (head == null || head.next == null) return head;
		ListNode newHead = reverseLinkedList(head.next);
		head.next.next = head;
		return newHead;
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
