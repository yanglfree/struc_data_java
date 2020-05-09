package linkedlist;

/**
 * https://leetcode-cn.com/problems/linked-list-cycle/
 * 快慢指针
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

		ListNode slowNode = head;
		ListNode fastNode = head.next;
		while (fastNode != null && fastNode.next != null) {
			slowNode = slowNode.next;
			fastNode = fastNode.next.next;
            if (slowNode == fastNode) return true;
		}
		return false;
    }

}
