package LinkList;
/*
 * Alternating split of a given Singly Linked List
 * http://www.geeksforgeeks.org/alternating-split-of-a-given-singly-linked-list/
 */
public class SLL_032_AlternatingSplitOfaLinkList {

	public ListNode[] split(ListNode head){
		ListNode result[] = new ListNode[2];
		if(head == null || head.next == null){
			result[0] = head;
			return result;
		}
		ListNode current = head;
		ListNode runner = current.next;
		
		while(runner != null){
			result[0] = LinkListOperations.addNodeAtEnd(result[0],current.data);
			result[1] = LinkListOperations.addNodeAtEnd(result[1],runner.data);
			
			current = current.next.next;
			//if even elems in original list
			if(current == null) break; 
			// if odd elems in original list
			if(current.next == null){
				result[0] = LinkListOperations.addNodeAtEnd(result[0],current.data);
				break;
			}
			runner = runner.next.next;
		}
		return result;
	}
	
	public static void main(String[] args) {
		SLL_032_AlternatingSplitOfaLinkList obj = new SLL_032_AlternatingSplitOfaLinkList();
		ListNode head = null;
		ListNode result[] = new ListNode[2];
        LinkListOperations ll = new LinkListOperations();
        head = ll.createLinkList();
        ll.printLinkList(head);
        result = obj.split(head);
        System.out.println("Split lists:");
        ll.printLinkList(result[0]);
        ll.printLinkList(result[1]);
	}
}
