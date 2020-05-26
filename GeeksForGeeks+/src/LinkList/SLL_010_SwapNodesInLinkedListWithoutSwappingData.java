//https://www.geeksforgeeks.org/swap-nodes-in-a-linked-list-without-swapping-data/
package LinkList;

public class SLL_010_SwapNodesInLinkedListWithoutSwappingData {

	public ListNode swapNodes(ListNode head, int x, int y){

			ListNode currX =  head;
			ListNode prevX = null;
			
			ListNode currY =  head;
			ListNode prevY = null;
			
			while(currX != null && currX.data != x){
				prevX = currX;
				currX = currX.next;
			}
			while(currY != null && currY.data != y) {
				prevY = currY;
				currY = currY.next;
			}
			
			// If either x or y is not present, nothing to do
	        if (currX == null || currY == null)
	            return head;
	 
	        // If x is not head of linked list
	        if (prevX != null)
	            prevX.next = currY;
	        else //make y the new head because prevX is null that means currX was head
	            head = currY;
	 
	        // If y is not head of linked list
	        if (prevY != null)
	            prevY.next = currX;
	        else // make x the new head  because prevY is null that means currY was head
	            head = currX;
	 
	        // Swap next pointers
	        ListNode ptr = currX.next;
	        currX.next = currY.next;
	        currY.next = ptr;
			return head;
	}
	
	public static void main(String[] args) {
			SLL_010_SwapNodesInLinkedListWithoutSwappingData obj = new SLL_010_SwapNodesInLinkedListWithoutSwappingData();
			ListNode head = null;
			LinkListOperations ll = new LinkListOperations();
			head = ll.createLinkList();
			ll.printLinkList(head);
			head = obj.swapNodes(head,3, 4);
			ll.printLinkList(head);
	}
}
