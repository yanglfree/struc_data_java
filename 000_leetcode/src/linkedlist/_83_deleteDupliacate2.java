package 链表;

import com.liang.ListNode;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 * @author michaelyang
 *
 */
public class _83_deleteDupliacate2 {
	public ListNode deleteDuplicateElement(ListNode head) {
		ListNode temp = head; // 辅助节点
		while (temp != null && temp.next != null) {
			if (temp.val == temp.next.val) {
				if (temp.next.next == null) {
					temp.next = null;
				}else {
					temp.next = temp.next.next;
				}
			}else {
				temp = temp.next;
			}
		}
		return head;
	}
}
