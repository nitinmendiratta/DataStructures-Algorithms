package Easy;

import Helper.LinkListNode;
import Helper.LinkListNode;

/*
 * https://leetcode.com/problems/remove-linked-list-elements/
 */
public class E_0203_RemoveLinkedListElements {

	 public LinkListNode removeElements(LinkListNode head, int val) {
		 if(head == null) return null;
	        while(head != null && head.val == val){
	            head = head.next;
	        }
	        LinkListNode ptr = head;
	        LinkListNode nextPtr = head;
	        while(ptr != null){
	            if(ptr.next != null && ptr.next.val == val){
	                nextPtr = ptr.next;
	                while(nextPtr != null && nextPtr.val == val){
	                    nextPtr = nextPtr.next;
	                }
	                ptr.next = nextPtr;
	            }
	            ptr = ptr.next;
	        }
	        return head;
	    }
	public static void main(String[] args) {
		E_0203_RemoveLinkedListElements obj = new E_0203_RemoveLinkedListElements();
		LinkListNode head = null;
	}

}
