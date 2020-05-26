package LinkList;
/*
 * http://www.geeksforgeeks.org/merge-a-linked-list-into-another-linked-list-at-alternate-positions/
 */
public class SLL_051_MergeaLinkListIntoAnotherLinkListAtAlternatePositions {

	public ListNode merge(ListNode a, ListNode b){
		if(a == null) return a;
		ListNode aptr = a;
		ListNode bptr = b;
		ListNode aNextPtr = a.next;
		ListNode bNextPtr = b.next;
		while(aptr != null && bptr != null){
			bptr.next = aNextPtr;
			aptr.next = bptr;
			aptr = aNextPtr;
			if(aNextPtr != null) aNextPtr = aNextPtr.next;
			bptr = bNextPtr;
			if(bNextPtr != null) bNextPtr = bNextPtr.next;
		}
		return a;
	}
	
	public static void main(String[] args) {
		SLL_051_MergeaLinkListIntoAnotherLinkListAtAlternatePositions obj = new SLL_051_MergeaLinkListIntoAnotherLinkListAtAlternatePositions();
		ListNode head1 = null;
		ListNode head2 = null;
		ListNode head = null;
        LinkListOperations ll = new LinkListOperations();
        head1 = ll.createLinkList();
        ll.printLinkList(head1);
        head2 = ll.createLinkList();
        ll.printLinkList(head2);
        head = obj.merge(head1,head2);
        System.out.println("Merged List is:");
        ll.printLinkList(head);
	}
}
