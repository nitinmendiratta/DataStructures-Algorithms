package Easy;

import Helper.LinkListNode;
import Helper.LinkListNode;

/*
 * https://leetcode.com/problems/middle-of-the-linked-list/
 */
public class E_0876_MiddleLinkedList {

	public LinkListNode middleNode(LinkListNode head) {
        LinkListNode slow = head;
        LinkListNode fast = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        return slow;
    }
	public static void main(String[] args) {
		E_0876_MiddleLinkedList obj = new E_0876_MiddleLinkedList();
		LinkListNode head = LinkListNode.createLinkList();
		System.out.println(obj.middleNode(head).val);
	}
}
