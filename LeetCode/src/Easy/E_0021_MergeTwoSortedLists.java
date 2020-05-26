package Easy;
import Helper.*;

/*
 * SLL_018: http://www.geeksforgeeks.org/merge-two-sorted-linked-lists/
 * https://leetcode.com/problems/merge-two-sorted-lists/
 */
public class E_0021_MergeTwoSortedLists {

	public LinkListNode mergeTwoListsOptimized(LinkListNode l1, LinkListNode l2) {
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		if(l1.val < l2.val){
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		} else{
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
	}
	public LinkListNode mergeTwoLists(LinkListNode a, LinkListNode b) {
		LinkListNode startNode = new LinkListNode(-1);
		LinkListNode result = startNode;
		LinkListNode ptr = startNode;
		LinkListNode newNode = null;

		boolean specialCase = false;
		if(a == null && b == null) return null;
		else if(a == null) return b;
		else if(b == null) return a;
		else{
			while(a != null && b != null){
				if(a.val == b.val){
					newNode = new LinkListNode(a.val);
					specialCase = true;
				}else if(a.val < b.val){
					newNode = new LinkListNode(a.val);
					a = a.next;
				}else if(b.val < a.val){
					newNode = new LinkListNode(b.val);
					b = b.next;
				}
				ptr.next = newNode;
				ptr = ptr.next;
				if(specialCase){
					LinkListNode newNode2 = new LinkListNode(a.val);
					ptr.next = newNode2;
					ptr = ptr.next;
					a = a.next;
					b = b.next;
					specialCase = false;
				}
			}
			if(a != null){
				ptr.next = a;
			}else if(b != null){
				ptr.next = b;
			}
		}
		return result.next;
	}
	public static void main(String[] args) {
		E_0021_MergeTwoSortedLists obj = new E_0021_MergeTwoSortedLists();
		LinkListNode head1 = new LinkListNode(1);
		head1.next = new LinkListNode(2);
		head1.next.next = new LinkListNode(4);

		LinkListNode head2 = new LinkListNode(1);
		head2.next = new LinkListNode(3);
		head2.next.next = new LinkListNode(4);
		LinkListNode head = obj.mergeTwoLists(head1,head2);
		System.out.println("Merged List is:");
		LinkListNode.printLinkList(head);
		head = obj.mergeTwoListsOptimized(head1,head2);
		System.out.println("Merged List optimized is:");
		LinkListNode.printLinkList(head);
	}
}