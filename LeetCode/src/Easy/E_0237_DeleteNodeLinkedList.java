package Easy;

import Helper.LinkListNode;
import Helper.LinkListNode;

/*
 * https://leetcode.com/problems/delete-node-in-a-linked-list/
 */
public class E_0237_DeleteNodeLinkedList {
	public void deleteNode(LinkListNode node) {
		LinkListNode ptr = node;
		while(ptr.next.next != null){
			ptr.val = ptr.next.val;
			ptr = ptr.next;
		}
		ptr.val = ptr.next.val;
		ptr.next = null;
	}
	public static void main(String[] args) {
		E_0237_DeleteNodeLinkedList obj = new E_0237_DeleteNodeLinkedList();
		LinkListNode head = null;
		head = LinkListNode.createLinkList();
		obj.deleteNode(head.next);
		LinkListNode.printLinkList(head);
	}
}
