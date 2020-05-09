package 链表;

/**
 * https://leetcode-cn.com/problems/linked-list-cycle/
 * @author michaelyang
 *
 */


public class _141_环形链表 {
	public static void main(String[] args) {
		ListNode head = new ListNode(10);
		hasCycle(head);
		
	}
	
	/**
	 * 使用快慢指针的方法来判断是否为环形链表
	 * @author michaelyang
	 */
	public static boolean hasCycle(ListNode head) {
		if (head == null || head.next == null) {
			return false;
		}
		
		ListNode slowNode = head;
		ListNode fastNode = head.next;
		while (fastNode != null && fastNode.next != null) {
			if (slowNode == fastNode) {
				return true;
			}
			slowNode = slowNode.next;
			fastNode = fastNode.next.next;
		}
		return false;
    }
}


