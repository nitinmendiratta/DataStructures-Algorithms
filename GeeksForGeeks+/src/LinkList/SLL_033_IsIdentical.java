package LinkList;

/*
 * http://www.geeksforgeeks.org/identical-linked-lists/
 */
 
public class SLL_033_IsIdentical {

	public boolean isIdentical(ListNode a, ListNode b){
		while(true){
			if(a == null && b == null) return true;
			if(a == null && b != null) return false;
			if(a != null && b == null) return false;
			a = a.next;
			b = b.next;
		}
	}

	public static void main(String[] args) {
		SLL_033_IsIdentical obj = new SLL_033_IsIdentical();
		ListNode head1 = null;
		ListNode head2 = null;
		ListNode head = null;
        LinkListOperations ll = new LinkListOperations();
        head1 = ll.createLinkList();
        ll.printLinkList(head1);
        head2 = ll.createLinkList();
        ll.printLinkList(head2);
        System.out.println("Identical:"+obj.isIdentical(head1,head2));
	}
}
