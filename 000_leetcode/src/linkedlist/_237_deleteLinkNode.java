package linkedlist;

/**
 * https://leetcode-cn.com/problems/delete-node-in-a-linked-list/ 
 * @author michaelyang
 *
 */
public class _237_deleteLinkNode {
	
	public static void main(String[] args) {
		
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
	
	public void deleteNode(ListNode node) {
        //获取给定节点的下�??个节点，将�?�覆盖给定节点，然后next指向下一个节点的下一个节�??
		node.val = node.next.val;
		node.next = node.next.next;
    }

}
