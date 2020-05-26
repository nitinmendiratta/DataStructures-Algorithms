package LinkList;
/*
 * http://www.geeksforgeeks.org/move-last-element-to-front-of-a-given-linked-list/
 */
public class SLL_029_MoveLastElementToFrontOfaLinkList {
	
	public ListNode moveLastToFront(ListNode head){
		if(head == null || head.next == null) return head;
		ListNode ptr = head;
		while(ptr.next.next != null) ptr = ptr.next;
		
		ptr.next.next = head;
		head = ptr.next;
		ptr.next = null;
		return head;
	}
	
	public static void main(String[] args) {
		SLL_029_MoveLastElementToFrontOfaLinkList obj = new SLL_029_MoveLastElementToFrontOfaLinkList();
		ListNode head = null;
		LinkListOperations ll = new LinkListOperations();
		head = ll.createLinkList();
		ll.printLinkList(head);
		head = obj.moveLastToFront(head);
		ll.printLinkList(head);
	}

}
