package LinkList;
/*
 * http://www.geeksforgeeks.org/segregate-even-and-odd-elements-in-a-linked-list/
 */
public class SLL_038_SegregateEvenAndOddNodesInALinkList {

	public ListNode segregate(ListNode head){
		if(head == null) return null;
		ListNode front = head;
		ListNode end = head;
		int count = 1;
		while(end.next != null){
			end = end.next;
			count++;
		}
		//handling first odd node below loop runs unless we get the first even node
		while((head.data%2) != 0){
			end.next = head;
			head = head.next;
			end = end.next;
			end.next = null;
			count--;
		}
		
		front = head;
		ListNode prev = front;
		ListNode temp = null;
		while(count > 0){
			if((front.data%2) != 0){
				end.next = front;
				temp = front.next;
				prev.next = temp;
				end = end.next;
				end.next = null;
				front = temp;
			}else{
				prev = front;
				front = front.next;
			}
			count--;
		}
		return head;
	}

	public static void main(String[] args) {
		SLL_038_SegregateEvenAndOddNodesInALinkList obj = new SLL_038_SegregateEvenAndOddNodesInALinkList();
		ListNode head = null;
		LinkListOperations ll = new LinkListOperations();
		head = ll.createLinkList();
		System.out.println("Original List");
		ll.printLinkList(head);
		System.out.println("Segregated List");
		head = obj.segregate(head);
		ll.printLinkList(head);
	}
}
