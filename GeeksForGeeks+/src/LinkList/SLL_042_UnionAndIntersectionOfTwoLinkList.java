package LinkList;
/*
 * http://www.geeksforgeeks.org/union-and-intersection-of-two-linked-lists/
 * TODO: Intersection and union using hashmap
 */
public class SLL_042_UnionAndIntersectionOfTwoLinkList {

	// Time Complexity: O(mn)
	public ListNode union(ListNode a, ListNode b){
		ListNode result = null;
		if(a == null && b == null) return null;
		else if(a == null) return b;
		else if(b == null) return a;
		else{
			ListNode ptr1 = a;
			ListNode ptr2 = b;
			while(ptr1 != null){
				ptr2 = b;
				while(ptr2 != null){
					if(ptr1.data != ptr2.data){
						ptr2 = ptr2.next;
					}else break;
				}
				if(ptr2 == null) result = LinkListOperations.addNodeAtEnd(result,ptr1.data);
				ptr1 = ptr1.next;
			}
			result = LinkListOperations.mergeLL(result,b);
		}
		return result;
	}
	
	public ListNode intersection(ListNode a, ListNode b){
		ListNode result = null;
		if(a == null || b == null) return null;
		else{
			ListNode ptr1 = a;
			ListNode ptr2 = b;
			while(ptr1 != null){
				ptr2 = b;
				while(ptr2 != null){
					if(ptr1.data == ptr2.data){
						result = LinkListOperations.addNodeAtEnd(result,ptr1.data);
						break;
					}
					ptr2 = ptr2.next;
				}
				ptr1 = ptr1.next;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		SLL_042_UnionAndIntersectionOfTwoLinkList obj = new SLL_042_UnionAndIntersectionOfTwoLinkList();
		ListNode head1 = null;
		ListNode head2 = null;
		ListNode head = null;
        LinkListOperations ll = new LinkListOperations();
        head1 = ll.createLinkList();
        ll.printLinkList(head1);
        head2 = ll.createLinkList();
        ll.printLinkList(head2);
        head = obj.union(head1,head2);
        System.out.println("union of lists is:");
        ll.printLinkList(head);
        head = obj.intersection(head1,head2);
        System.out.println("Intersection of lists is:");
        ll.printLinkList(head);
	}
}
