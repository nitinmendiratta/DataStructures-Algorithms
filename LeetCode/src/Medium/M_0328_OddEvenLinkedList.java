package Medium;
import Helper.LinkListNode;
/*
 * https://leetcode.com/problems/odd-even-linked-list/
 */
public class M_0328_OddEvenLinkedList {

	public LinkListNode oddEvenList(LinkListNode head) {
		if(head == null || head.next == null) return head;
		
		LinkListNode oddPtr = head, head2 = head.next, evenPtr = head.next;
		
		while(evenPtr != null && evenPtr.next != null) {
			oddPtr.next = oddPtr.next.next;
			evenPtr.next = evenPtr.next.next;
			oddPtr = oddPtr.next;
			evenPtr = evenPtr.next;
		}
		oddPtr.next = head2;
		return head;
	}

	public static void main(String[] args) {
		M_0328_OddEvenLinkedList obj = new M_0328_OddEvenLinkedList();
		LinkListNode head = LinkListNode.createLinkList();
		obj.oddEvenList(head);
		LinkListNode.printLinkList(head);
	}

}
