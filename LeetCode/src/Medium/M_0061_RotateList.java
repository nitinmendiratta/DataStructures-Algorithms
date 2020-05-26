package Medium;
import Easy.*;
import Helper.LinkListNode;
import Helper.LinkListNode;
/*
 * https://leetcode.com/problems/rotate-list/
 */
public class M_0061_RotateList {

	public LinkListNode rotateRight(LinkListNode head, int k) {
		if(k == 0 || head == null || head.next == null) return head;
		int len = 1, count = 0;
		LinkListNode ptr = head;
		LinkListNode lastPtr = head;
		
		//Get the total length 
		while(lastPtr.next != null) {
			lastPtr = lastPtr.next;
			len++;
		}
		
		// get the kth node from last
		k = len - k%len - 1;

		while(count < k) {
			ptr = ptr.next;
			count++;
		}
		//Do the rotation
		lastPtr.next = head;
		head = ptr.next;
		ptr.next = null;
		return head;
	}
	public static void main(String[] args) {
		M_0061_RotateList obj = new M_0061_RotateList();
		LinkListNode head = LinkListNode.createLinkList();
		LinkListNode.printLinkList(head);
		LinkListNode.printLinkList(obj.rotateRight(head, 2));
	}
}
