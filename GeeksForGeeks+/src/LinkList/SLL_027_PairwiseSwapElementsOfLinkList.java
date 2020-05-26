package LinkList;
/*
 * http://www.geeksforgeeks.org/pairwise-swap-elements-of-a-given-linked-list/
 * http://www.geeksforgeeks.org/pairwise-swap-elements-of-a-given-linked-list-by-changing-links/
 */
public class SLL_027_PairwiseSwapElementsOfLinkList {

	public ListNode pairwiseSwap(ListNode head){
		if(head == null || head.next == null) return head;

		ListNode current = head;
		ListNode runner = head.next;
		ListNode prev = current;

		current.next = runner.next;
		runner.next = current;
		head = runner;

		current = current.next;
		runner = current.next;

		while(runner != null){
			current.next = runner.next;
			runner.next = current;
			prev.next = runner;
			prev = current;
			current = current.next;
			if(current != null) runner = current.next;
			else runner = null;
		}
		return head;
	}
	
	public ListNode swap(ListNode head){
		if(head == null || head.next == null) return head;
		ListNode ptr = head;
		
		while(ptr != null && ptr.next != null){
			int temp = ptr.data;
			ptr.data = ptr.next.data;
			ptr.next.data = temp;
			
			ptr = ptr.next.next;
		}
		return head;
	}
	public static void main(String[] args) {
		SLL_027_PairwiseSwapElementsOfLinkList obj = new SLL_027_PairwiseSwapElementsOfLinkList();
		ListNode head = null;
		LinkListOperations ll = new LinkListOperations();
		head = ll.createLinkList();
		ll.printLinkList(head);
		head = obj.swap(head);
		ll.printLinkList(head);
	}
}
