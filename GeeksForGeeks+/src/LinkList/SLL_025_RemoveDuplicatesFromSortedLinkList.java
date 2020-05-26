package LinkList;
/*
 * http://www.geeksforgeeks.org/remove-duplicates-from-a-sorted-linked-list/
 */
public class SLL_025_RemoveDuplicatesFromSortedLinkList {

	public ListNode removeDup(ListNode head){
		if(head == null || head.next == null) return head;
		int flag = 0;
		ListNode current = head;
		ListNode runner = head.next;
		while(runner != null){
			while(runner.data == current.data){
				runner = runner.next;
				flag = 1;
				if(runner == null) break;
			}
			
			if(flag == 1){
				current.next = runner;
				if(runner != null){
					current = current.next;
					runner = runner.next;
				}
				flag = 0;
			}
			else{
				current = current.next;
				runner = runner.next;
			}
		}
		return head;
	}

	public static void main(String[] args) {
		SLL_025_RemoveDuplicatesFromSortedLinkList obj = new SLL_025_RemoveDuplicatesFromSortedLinkList();
		ListNode head = null;
		LinkListOperations ll = new LinkListOperations();
		head = ll.createLinkList();
		ll.printLinkList(head);
		head = obj.removeDup(head);
		ll.printLinkList(head);
	}
}
