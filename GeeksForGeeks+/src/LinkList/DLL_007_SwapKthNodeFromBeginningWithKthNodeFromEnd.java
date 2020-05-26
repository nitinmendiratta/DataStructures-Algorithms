package LinkList;
/*
 * http://www.geeksforgeeks.org/swap-kth-node-from-beginning-with-kth-node-from-end-in-a-linked-list/
 */
public class DLL_007_SwapKthNodeFromBeginningWithKthNodeFromEnd {

	public ListNode swap(ListNode head, int k){
		if(head == null) return head;
		ListNode ptr = head;
		ListNode kthPtr = head;
		int n = 0;
		while(ptr !=  null){
			ptr = ptr.next;
			n++;
		}
		ptr = head;
		if(n < k) return head;
		if(2*k -1 == n) return head;
		
		//swap
		head = actualSwap(head,k,n-k+1,n);
		return head;
	}
	
	public ListNode actualSwap(ListNode head, int m, int n, int len){
		ListNode mthNode = head;
		ListNode prevMthNode = null;
		ListNode nthNode = head;
		ListNode prevNthNode = null;
		int count = m;
		while(count > 1){
			prevMthNode = mthNode;
			mthNode = mthNode.next;
			count--;
		}
		count = n;
		while(count > 1){
			prevNthNode = nthNode;
			nthNode = nthNode.next;
			count--;
		}
		
		if(prevMthNode != null) prevMthNode.next = nthNode;
		if(prevNthNode != null) prevNthNode.next = mthNode;
		ListNode temp = mthNode.next;
		mthNode.next = nthNode.next;
		nthNode.next = temp;
		
		if(m == 1) head = nthNode;
		if(m == len) head = mthNode;
		return head;
	}
	
	public static void main(String[] args) {
		DLL_007_SwapKthNodeFromBeginningWithKthNodeFromEnd obj = new DLL_007_SwapKthNodeFromBeginningWithKthNodeFromEnd();
		ListNode head = null;
		LinkListOperations ll = new LinkListOperations();
		head = ll.createLinkList();
		ll.printLinkList(head);
		head = obj.swap(head,3);
		ll.printLinkList(head);
	}
}
