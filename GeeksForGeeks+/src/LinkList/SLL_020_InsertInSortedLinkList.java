//http://www.geeksforgeeks.org/given-a-linked-list-which-is-sorted-how-will-you-insert-in-sorted-way/
package LinkList;

public class SLL_020_InsertInSortedLinkList {

	public ListNode insert(ListNode head, int data){
		ListNode ptr = null;
		ListNode new_node = new ListNode(data);
		 
        /* Special case for head node */
        if (head == null || head.data >= new_node.data){
           new_node.next = head;
           head = new_node;
        }
        else {

           /* Locate the node before point of insertion. */
           ptr = head;

           while (ptr.next != null && ptr.next.data < new_node.data){
                 ptr = ptr.next;
           }

           new_node.next = ptr.next;
           ptr.next = new_node;
        }
        return head;
	}
	
	public static void main(String[] args) {
		SLL_020_InsertInSortedLinkList obj = new SLL_020_InsertInSortedLinkList();
		ListNode head = null;
		LinkListOperations ll = new LinkListOperations();
		head = ll.createLinkList();
		ll.printLinkList(head);
		head = obj.insert(head, 3);
		ll.printLinkList(head);
	}
}
