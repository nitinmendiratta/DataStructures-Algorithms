package Easy;

import Helper.LinkListNode;
import Helper.LinkListNode;

/*
 * https://leetcode.com/problems/reverse-linked-list/
 */
public class E_0206_ReverseLinkedList {
	
	 public LinkListNode reverseList(LinkListNode head) {
	        LinkListNode prev = null, curr = head;
	        if(head == null || head.next == null){
	            return head;
	        }
	        LinkListNode next = head.next;
	        while(curr != null){
	            curr.next = prev;
	            prev = curr;
	            curr = next;
	            if(next != null){
	                next = next.next;
	            }
	        }
	        return prev;
	    }
	public static void main(String[] args) {
		E_0206_ReverseLinkedList obj = new E_0206_ReverseLinkedList();
		LinkListNode head = null;
		head = LinkListNode.createLinkList();
		head = obj.reverseList(head);
		LinkListNode.printLinkList(head);
	}
}
