package LinkList;
/*
 * http://www.geeksforgeeks.org/detect-and-remove-loop-in-a-linked-list/
 */

public class SLL_039_DetectAndRemoveLoopInaLinkList {

	public ListNode detectRemoveLoop(ListNode head){
		if(head == null || head.next == null) return head;

		ListNode current = head;
		ListNode runner = head;

		while(current != null || runner != null){
			current = current.next;
			runner = runner.next.next;
			if(current == runner) break;
		}

		if(current == null || runner == null){
			System.out.println("no loop");
			return head;
		}
		current = head;
		ListNode prev = head;
		while(current != runner){
			prev = runner;
			current = current.next;
			runner = runner.next;
		}
		prev.next = null;
		return head;
	}

	public static void main(String[] args) {
		SLL_039_DetectAndRemoveLoopInaLinkList obj = new SLL_039_DetectAndRemoveLoopInaLinkList();
		ListNode head = null;
		LinkListOperations ll = new LinkListOperations();
		head = ll.createCLL();
		// ll.printLinkList(head);
		head = obj.detectRemoveLoop(head);
		//System.out.println(head.data);
		ll.printLinkList(head);
	}
}
