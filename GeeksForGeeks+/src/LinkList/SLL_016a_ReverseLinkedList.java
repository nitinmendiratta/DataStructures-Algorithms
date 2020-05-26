//http://www.geeksforgeeks.org/write-a-function-to-reverse-the-nodes-of-a-linked-list/
package LinkList;

public class SLL_016a_ReverseLinkedList {

	//Time Complexity: O(n), Space Complexity: O(1)
	public ListNode reverseLL(ListNode head){
		ListNode prev = null;
		ListNode curr = head;
		ListNode next = null;
		while(curr != null){
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		head = prev;
		return head;
	}
	
	/* 1) Divide the list in two parts - first node and rest of the linked list.
	   2) Call reverse for the rest of the linked list.
	   3) Link rest to first.
	   4) Fix head pointer
	*/
	// not working as expected
	public void reverseLLUsingRecursion(ListNode head){

		ListNode first;
		ListNode rest;
	      
	    /* empty list */
	    if (head == null)
	       return;   
	 
	    /* suppose first = {1, 2, 3}, rest = {2, 3} */
	    first = head;  
	    rest  = first.next;
	 
	    /* List has only one node */
	    if (rest == null)
	       return;   
	 
	    /* reverse the rest list and put the first element at the end */
	    reverseLLUsingRecursion(rest);
	    first.next.next  = first;  
	     
	    /* tricky step -- see the diagram */
	    first.next  = null;          
	 
	    /* fix the head pointer */
	    head = rest;
	}
	
	public static void main(String[] args) {
			SLL_016a_ReverseLinkedList obj = new SLL_016a_ReverseLinkedList();
			ListNode head = null;
			LinkListOperations ll = new LinkListOperations();
			head = ll.createLinkList();
			ll.printLinkList(head);
			head = obj.reverseLL(head);
			ll.printLinkList(head);
	}

}
