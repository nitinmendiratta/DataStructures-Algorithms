 /* http://www.geeksforgeeks.org/remove-duplicates-from-a-sorted-linked-list/
 * http://www.geeksforgeeks.org/remove-duplicates-from-an-unsorted-linked-list/
 */
package LinkList;
import java.util.Hashtable;

public class SLL_026_RemoveDuplicatesFromSortedAndUnsortedLinkeList {

	//Time Complexity: O(n) where n is number of nodes in the given linked list
	public ListNode removeDuplicatesFromSortedLL(ListNode head){
		if(head == null){
			return null;
		}
		ListNode current = head;
		ListNode temp = null;
		
		while(current.next != null){
			if(current.data == current.next.data){
				temp = current.next.next;
				current.next = null;
				current.next = temp;
			}else{
				current = current.next;
			}
		}
		return head;
	}
	
	//Time Complexity: O(n) on average (assuming that hash table access time is O(1) on average).
	public ListNode removeDuplicatesFromUnSortedLL(ListNode head){
		if(head == null){
			return null;
		}
		ListNode current = head;
		ListNode temp = null;
		Hashtable<Integer,Boolean> hash = new Hashtable<Integer,Boolean>();
		while(current.next != null){
			if(hash.containsKey(current.next.data)|| current.data == current.next.data){
				temp = current.next.next;
				current.next = null;
				current.next = temp;
			}else{
				hash.put(current.data, true);
				current = current.next;
			}
		}
		return head;
	}
		
	public static void main(String[] args) {
		SLL_026_RemoveDuplicatesFromSortedAndUnsortedLinkeList obj = new SLL_026_RemoveDuplicatesFromSortedAndUnsortedLinkeList();
		ListNode head = null;
		LinkListOperations ll = new LinkListOperations();
		head = ll.createLinkList();
		ll.printLinkList(head);
		obj.removeDuplicatesFromSortedLL(head);
		ll.printLinkList(head);
		head = ll.createLinkList();
		ll.printLinkList(head);
		obj.removeDuplicatesFromUnSortedLL(head);
		ll.printLinkList(head);
	}
}
