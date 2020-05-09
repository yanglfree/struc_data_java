package linkedlist;

import com.liang.ListNode;

/**
 *  递归的方法来反转链表
 */
public class _206_reverseLinkedlist2 {
    
    public ListNode reverseLinkedlist(ListNode head) {

        if (head == null || head.next == null) { return head; }
        ListNode newHead = reverseLinkedlist(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}