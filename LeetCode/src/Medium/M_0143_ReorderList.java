package Medium;
import Helper.LinkListNode;
/*
 * https://leetcode.com/problems/reorder-list/
 */
public class M_0143_ReorderList {

	public void reorderList(LinkListNode head) {
		if (head == null) {
			return;
		}

		// Find the middle node
		LinkListNode slow = head, fast = head.next;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		// Reverse the second half
		// Reverse the half after middle 1->2->3->4->5->6 to 1->2->3->6->5->4
		LinkListNode head2 = LinkListNode.reverseLinkList(slow.next);
		slow.next = null;

		// Link the two halves together
		// Start reorder one by one 1->2->3->6->5->4 to 1->6->2->5->3->4
		while (head != null && head2 != null) {
			LinkListNode ptr1 = head.next;
			LinkListNode ptr2 = head2.next;
			head2.next = head.next;
			head.next = head2;
			head = ptr1;
			head2 = ptr2;
		}
	}

	public static void main(String[] args) {
		M_0143_ReorderList obj = new M_0143_ReorderList();
		LinkListNode head = LinkListNode.createLinkList();
		obj.reorderList(head);
		LinkListNode.printLinkList(head);
	}
}
