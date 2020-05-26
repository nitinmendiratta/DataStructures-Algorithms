package Medium;

import Helper.LinkListNode;

/*
 * https://leetcode.com/problems/insertion-sort-list/
 */
public class M_0147_InsertionSortList {

	public LinkListNode insertionSortList(LinkListNode head) {
		LinkListNode dummy = new LinkListNode(0);
		LinkListNode prev = dummy;

		while (head != null) {
			LinkListNode temp = head.next;

			/*
			 * Before insert, the prev is at the last node of the sorted list. Only the last
			 * node's value is larger than the current inserting node should we move the
			 * temp back to the head
			 */
			if (prev.val >= head.val)
				prev = dummy;

			while (prev.next != null && prev.next.val < head.val) {
				prev = prev.next;
			}

			head.next = prev.next;
			prev.next = head;
			// prev = dummy; // Don't set prev to the head of the list after insert
			head = temp;
		}
		return dummy.next;
	}

	// my approach
	public LinkListNode insertionSortListApproach2(LinkListNode head) {
		if (head == null || head.next == null)
			return head;
		int len = 1;
		LinkListNode ptr = head, prev = head, newPtr = head.next, newHead = newPtr;

		while (newPtr.next != null) {
			newPtr = newPtr.next;
			prev = prev.next;
			len++;
		}

		newHead = newPtr;

		while (len > 0) {

			head = ptr.next;

			if (ptr.val <= newHead.val) {
				// insert front of newhead
				prev.next = ptr;
				ptr.next = newHead;
				newHead = ptr;
			} else {
				// insert after newPtr at right position
				while (newPtr.next != null && ptr.val > newPtr.next.val) {
					newPtr = newPtr.next;
				}
				ptr.next = newPtr.next;
				newPtr.next = ptr;
			}
			newPtr = newHead;
			ptr = head;
			len--;
		}
		return newHead;
	}

	public static void main(String[] args) {
		M_0147_InsertionSortList obj = new M_0147_InsertionSortList();
		LinkListNode head = LinkListNode.createLinkList();
		LinkListNode newHead = obj.insertionSortList(head);
		LinkListNode.printLinkList(newHead);
	}
}
