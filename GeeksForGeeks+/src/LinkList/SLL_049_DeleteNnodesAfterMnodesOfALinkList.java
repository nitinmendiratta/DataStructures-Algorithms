package LinkList;
/*
 * https://www.geeksforgeeks.org/delete-n-nodes-after-m-nodes-of-a-linked-list/
 */
public class SLL_049_DeleteNnodesAfterMnodesOfALinkList {

	public ListNode delete(ListNode head, int m, int n){
		if(head == null) return head;
		ListNode ptr = head;
		int count = 1;
		while(ptr.next != null){
			ptr = ptr.next;
			count++;
		}
		
		if(count < (m+n)) return head;
		
		ptr = head;
		while(m > 1){
			ptr = ptr.next;
			m--;
		}
		ListNode nthNode = ptr.next;
		while(n > 1){
			nthNode = nthNode.next;
			n--;
		}
		ptr.next = nthNode.next;
		return head;
	}
	
	public static void main(String[] args) {
		SLL_049_DeleteNnodesAfterMnodesOfALinkList obj = new SLL_049_DeleteNnodesAfterMnodesOfALinkList();
		ListNode head = null;
        LinkListOperations ll = new LinkListOperations();
        head = ll.createLinkList();
        ll.printLinkList(head);
        head = obj.delete(head,2,2);
        ll.printLinkList(head);
	}
}
