package LinkList;
/* http://www.geeksforgeeks.org/find-a-triplet-from-three-linked-lists-with-sum-equal-to-a-given-number/
 */
public class SLL_043_FindTripletFromThreeLinkListWithSumEqualToaGivenNumber {
	// complexity n3
	public ListNode sumToValueApproach1(ListNode a, ListNode b, ListNode c, int x){
		if(a == null || b == null || c == null) return null;
		ListNode result = null;
		ListNode ptr1 = a;
		ListNode ptr2 = b;
		ListNode ptr3 = c;

		while(ptr1 != null){
			ptr2 = b;
			while(ptr2 != null){
				ptr3 = c;
				while(ptr3 != null){
					if((ptr1.data + ptr2.data + ptr3.data) == x){
						result = LinkListOperations.addNodeAtEnd(result,ptr1.data);
						result = LinkListOperations.addNodeAtEnd(result,ptr2.data);
						result = LinkListOperations.addNodeAtEnd(result,ptr3.data);
						return result;
					}
					ptr3 = ptr3.next;
				}
				ptr2 = ptr2.next;
			}
			ptr1 = ptr1.next;
		}
		return result;
	}

	/*complexity n2
	 *	Sorting can be used to reduce the time complexity to O(n*n). Following are the detailed steps.
		1) Sort list b in ascending order, and list c in descending order.
		2) After the b and c are sorted, one by one pick an element from list a and find the pair by traversing both b and c.
	 */
	public ListNode sumToValueApproach2(ListNode a, ListNode b, ListNode c, int x){
		//b = LinkListOperations.sortLL(b);
		//c = LinkListOperations.sortLL(c);
		if(a == null || b == null || c == null) return null;
		ListNode result = null;
		ListNode ptr1 = a;
		ListNode ptr2 = b;
		ListNode ptr3 = c;
		int sum = 0;
		while(ptr1 != null){
			ptr2 = b;
			ptr3 = c;
			while(ptr2 != null && ptr3 != null){
				sum = ptr1.data + ptr2.data + ptr3.data;
				if(sum == x){
					result = LinkListOperations.addNodeAtEnd(result,ptr1.data);
					result = LinkListOperations.addNodeAtEnd(result,ptr2.data);
					result = LinkListOperations.addNodeAtEnd(result,ptr3.data);
					return result;
				}
				else if(sum < x){
					ptr2 = ptr2.next;
				}else{
					ptr3 = ptr3.next;
				}
			}
			ptr1 = ptr1.next;
		}
		return result;
	}

	public static void main(String[] args) {
		SLL_043_FindTripletFromThreeLinkListWithSumEqualToaGivenNumber obj = new SLL_043_FindTripletFromThreeLinkListWithSumEqualToaGivenNumber();
		ListNode head1 = null;
		ListNode head2 = null;
		ListNode head3 = null;
		ListNode head = null;
		LinkListOperations ll = new LinkListOperations();
		head1 = ll.createLinkList();
		ll.printLinkList(head1);
		head2 = ll.createLinkList();
		ll.printLinkList(head2);
		head3 = ll.createLinkList();
		ll.printLinkList(head3);
		head = obj.sumToValueApproach2(head1,head2,head3,101);
		System.out.println("Result LL is:");
		ll.printLinkList(head);
	}
}
