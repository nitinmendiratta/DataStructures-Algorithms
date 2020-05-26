package LinkList;
/*
 * http://www.geeksforgeeks.org/intersection-of-two-sorted-linked-lists/
 */
 
public class SLL_030_IntersectionOfTwoSortedLinkLists {
	
	public ListNode intersection(ListNode a, ListNode b){
		if(a == null || b == null) return null;
		ListNode head = null;
		
		while(a != null && b != null){			
			if(a.data == b.data){
				head = LinkListOperations.addNodeAtEnd(head,a.data);
				a = a.next;
				b = b.next;
			}
			else if(a.data < b.data){
				a = a.next;
			}else{
				b = b.next;
			}
		}
		return head;
	}
	
	public static void main(String[] args) {
		SLL_030_IntersectionOfTwoSortedLinkLists obj = new SLL_030_IntersectionOfTwoSortedLinkLists();
		ListNode head1 = null;
		ListNode head2 = null;
		ListNode head = null;
        LinkListOperations ll = new LinkListOperations();
        head1 = ll.createLinkList();
        ll.printLinkList(head1);
        head2 = ll.createLinkList();
        ll.printLinkList(head2);
        head = obj.intersection(head1,head2);
        System.out.println("Intersection is:");
        ll.printLinkList(head);
	}
}
