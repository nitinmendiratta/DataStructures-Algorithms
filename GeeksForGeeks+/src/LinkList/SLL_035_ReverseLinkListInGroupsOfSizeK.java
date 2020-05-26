package LinkList;
/*
 * http://www.geeksforgeeks.org/reverse-a-list-in-groups-of-given-size/
 */
public class SLL_035_ReverseLinkListInGroupsOfSizeK{

	public ListNode reverseInGroups(ListNode head, int k){
		if(head == null) return head;
		int len = 1;
		ListNode ptr = head;
		ListNode head2 = head;
		ListNode result = null;
		
		while(ptr.next != null){
			ptr = ptr.next;
			len++;
		}
		
		if(len < k ) return head;
		int count = len/k;

		while(count > 0){
			head2 = head;
			ptr = head;
			int i = 1;
			while(i < k){
				ptr = ptr.next;
				i++;
			}
			head = ptr.next;
			ptr.next = null;
			ListNode temp = LinkListOperations.reverseLinkList(head2);
			result = merge(result,temp);
			count--;
		}
		
		if(head != null){
			head = LinkListOperations.reverseLinkList(head);
			result = merge(result,head);
		}
		return result;
	}

	public ListNode merge(ListNode a, ListNode b){
		if(a == null) return b;
		else if(b == null) return a;
		else{
			ListNode ptr = a;
			while(ptr.next != null){
				ptr = ptr.next;
			}
			ptr.next = b;
			return a;
		}
	}
	
	public static void main(String[] args) {
		SLL_035_ReverseLinkListInGroupsOfSizeK obj = new SLL_035_ReverseLinkListInGroupsOfSizeK();
		ListNode head = null;
		LinkListOperations ll = new LinkListOperations();
		head = ll.createLinkList();
		ll.printLinkList(head);
		head = obj.reverseInGroups(head,5);
		ll.printLinkList(head);
	}
}
