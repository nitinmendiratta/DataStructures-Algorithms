package Easy;

import Helper.LinkListNode;

/*
 * https://oj.leetcode.com/problems/remove-duplicates-from-sorted-list/
 */
public class E_0083_RemoveDuplicatesFromSortedList {

	public LinkListNode deleteDuplicates(LinkListNode head) {
		LinkListNode ptr = head;
        while(ptr != null && ptr.next != null){
            if(ptr.val == ptr.next.val){
                ptr.next = ptr.next.next;
            }else{
                ptr = ptr.next;
            }
        }
        return head;
    }

	public void printLinkList(LinkListNode head){
		LinkListNode ptr = head;
		if(head == null) System.out.println("List is empty");
		while(ptr != null){
			System.out.print(ptr.val+"->");
			ptr = ptr.next;
		}
		System.out.println();
	}
	public static void main(String[] args) {
		E_0083_RemoveDuplicatesFromSortedList obj = new E_0083_RemoveDuplicatesFromSortedList();
		LinkListNode head1 = null;
		LinkListNode temp[] = new LinkListNode[6];

		for(int i=0;i<6;i++)	temp[i] = new LinkListNode(0);
		// 1->1->2->null

		temp[0].val = 1;
		temp[0].next = temp[1];
		temp[1].val = 1;
		temp[1].next = temp[2];
		temp[2].val = 2;
		temp[2].next = temp[3];
		temp[3].val = 1;
		temp[3].next = temp[4];
		temp[4].val = 1;
		temp[4].next = temp[5];
		temp[5].val = 1;
		head1 = temp[0];
		obj.printLinkList(head1);
		LinkListNode result = obj.deleteDuplicates(head1);
		obj.printLinkList(result);
	}
}
