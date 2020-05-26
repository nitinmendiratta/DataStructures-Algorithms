//http://www.geeksforgeeks.org/given-only-a-pointer-to-a-node-to-be-deleted-in-a-singly-linked-list-how-do-you-delete-it/
package LinkList;

public class SLL_021_DeleteNodeWithOnly1PointerToThatNode {

	public void delete(ListNode ptr){
		ptr.data = ptr.next.data;
		ptr.next = ptr.next.next;
	}
	
	public static void main(String[] args) {
		SLL_021_DeleteNodeWithOnly1PointerToThatNode obj = new SLL_021_DeleteNodeWithOnly1PointerToThatNode();
		ListNode head = null;
		LinkListOperations ll = new LinkListOperations();
		head = ll.createLinkList();
		ll.printLinkList(head);
		obj.delete(head.next);
		ll.printLinkList(head);
	}
}
