package LinkList;
/*
 * http://www.geeksforgeeks.org/sort-a-linked-list-of-0s-1s-or-2s/
 */
public class SLL_047_SortLinkListOf0s1sAnd2s {
	
	public ListNode sort(ListNode head){
		if(head == null || head.next == null) return head;
		int[] count = {0,0,0};
		ListNode ptr = head;
		
		while(ptr != null){
			count[ptr.data] += 1;
			ptr = ptr.next;
		}
		int i = 0;
		ptr = head;
		
		while(i < 3){
			ptr.data = i;
			count[i]--;
			ptr = ptr.next;
			if(count[i] == 0) i++;
		}
		return head;
	}
	
	public static void main(String[] args) {
		SLL_047_SortLinkListOf0s1sAnd2s obj = new SLL_047_SortLinkListOf0s1sAnd2s();
		ListNode head = null;
        LinkListOperations ll = new LinkListOperations();
        head = ll.createLinkList();
        ll.printLinkList(head);
        head = obj.sort(head);
        ll.printLinkList(head);
	}
}
