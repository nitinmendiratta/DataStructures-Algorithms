package LinkList;
/*
 * http://www.geeksforgeeks.org/delete-alternate-nodes-of-a-linked-list/
 */
 
public class SLL_031_DeleteAlternateNodesOfaLinkList {

	public ListNode deleteAlternateNodes(ListNode head){
		if(head == null || head.next == null) return head;
		ListNode ptr = head;
		while(ptr != null && ptr.next != null){
			ptr.next = ptr.next.next;
			ptr = ptr.next;
		}
		return head;
	}
	
	public static void main(String[] args) {
		SLL_031_DeleteAlternateNodesOfaLinkList obj = new SLL_031_DeleteAlternateNodesOfaLinkList();
		ListNode head = null;
        LinkListOperations ll = new LinkListOperations();
        head = ll.createLinkList();
        ll.printLinkList(head);
        head = obj.deleteAlternateNodes(head);
        ll.printLinkList(head);
	}
}
