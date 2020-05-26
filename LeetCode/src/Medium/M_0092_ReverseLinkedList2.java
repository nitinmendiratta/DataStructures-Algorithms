package Medium;
import Helper.*;
/*
 * https://leetcode.com/problems/reverse-linked-list-ii/
 */
public class M_0092_ReverseLinkedList2 {

	public LinkListNode reverseBetween(LinkListNode head, int m, int n) {
		if (head == null || m >= n) {
			return head;
		}
		int count = 1;
		LinkListNode mPrev = head, nPtr = null, curr = head;
		
		// special case when m = 1
		LinkListNode dummyNode = new LinkListNode(0);
		dummyNode.next = head;
		if(m == 1) mPrev = dummyNode;

		// Find the mth and nth node
		while (count <= n) {
			if(count == m-1) mPrev = curr;
			if(count == n) nPtr = curr;
			curr = curr.next;
			count++;
		}

		nPtr.next = null; // mark end of 2nd part to null
		nPtr = curr; // point to start of third part
		LinkListNode nPrev = mPrev.next;
		curr = LinkListNode.reverseLinkList(mPrev.next);
		
		mPrev.next = curr;
		nPrev.next = nPtr;
		if(m == 1) return dummyNode.next;
		return head;
	}

	public static void main(String[] args) {
		M_0092_ReverseLinkedList2 obj = new M_0092_ReverseLinkedList2();
		LinkListNode head = LinkListNode.createLinkList();
		LinkListNode.printLinkList(obj.reverseBetween(head, 2, 5));
	}
}
