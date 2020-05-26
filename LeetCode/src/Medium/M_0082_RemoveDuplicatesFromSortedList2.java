package Medium;
import Easy.*;
import Helper.LinkListNode;
import Helper.LinkListNode;
/*
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 */
public class M_0082_RemoveDuplicatesFromSortedList2 {

	public LinkListNode deleteDuplicates(LinkListNode head) {
		if(head == null || head.next == null) return head;
		//use two pointers, slow - track the node before the dup nodes, 
		// fast - to find the last node of dups.
		LinkListNode dummy = new LinkListNode(0), fast = head, slow = dummy;
		slow.next = fast;

		while(fast != null) {
			while (fast.next != null && fast.val == fast.next.val) {
				fast = fast.next;    //while loop to find the last node of the dups.
			}

			if (slow.next != fast) { //duplicates detected.
				slow.next = fast.next; //remove the dups.
			} else { //no dup, move down both pointer.
				slow = slow.next;
			}
			fast = fast.next;
		}
		return dummy.next;
	}

	// recursive
	public LinkListNode deleteDuplicatesApproach2(LinkListNode head) {
		if (head == null) return null;

		if (head.next != null && head.val == head.next.val) {
			while (head.next != null && head.val == head.next.val) {
				head = head.next;
			}
			return deleteDuplicates(head.next);
		} else {
			head.next = deleteDuplicates(head.next);
		}
		return head;
	}

	// My approach: too many pointers
	public LinkListNode deleteDuplicatesMyApproach(LinkListNode head) {
		LinkListNode prev = new LinkListNode(0);
		LinkListNode res = prev;
		prev.next = head;
		LinkListNode curr = head;
		LinkListNode fast = head.next;
		boolean dupFlag = false;

		while(fast != null) {

			if(curr.val == fast.val) {
				dupFlag = true;
			} else {

				// case when prev elements were dup and we now we have non dup
				if(dupFlag && (fast.next == null || fast.val != fast.next.val)) {
					prev.next = fast;
					prev = fast;
					curr = curr.next;
					fast = fast.next;
					dupFlag = false;
				}else if(!dupFlag){
					prev = prev.next;
				}
			}
			if(curr != null && fast != null) {
				curr = curr.next;
				fast = fast.next;
			}
		}
		if(dupFlag) prev.next = null;
		return res.next;
	}
	public static void main(String[] args) {
		M_0082_RemoveDuplicatesFromSortedList2 obj = new M_0082_RemoveDuplicatesFromSortedList2();
		LinkListNode head = LinkListNode.createLinkList();
		head = obj.deleteDuplicates(head);
		LinkListNode.printLinkList(head);
	}
}
