package Medium;
import Easy.*;
import Helper.LinkListNode;
import Helper.LinkListNode;
/*
 * https://leetcode.com/problems/partition-list/
 */
public class M_0086_PartitionList {

	// the basic idea is to maintain two queues, the first one stores all nodes with val less than x , 
	// and the second queue stores all the rest nodes. Then concat these two queues. Remember to set the tail of second queue a null next
	
	public LinkListNode partition(LinkListNode head, int x) {
		LinkListNode dummy1 = new LinkListNode(0), dummy2 = new LinkListNode(0);  //dummy heads of the 1st and 2nd queues
		LinkListNode curr1 = dummy1, curr2 = dummy2;      //current tails of the two queues;
		
		while (head != null){
			if (head.val<x) {
				curr1.next = head;
				curr1 = head;
			}else {
				curr2.next = head;
				curr2 = head;
			}
			head = head.next;
		}
		curr2.next = null;          //important! avoid cycle in linked list. otherwise u will get TLE.
		curr1.next = dummy2.next;
		return dummy1.next;
	}


	// my approach
	public LinkListNode partitionApproach2(LinkListNode head, int x) {
		if(head == null || head.next == null) return head;
		LinkListNode dummy = new LinkListNode(0), curr = head;
		dummy.next = head;
		LinkListNode slow = dummy;

		// find prev to first node >= x
		while(slow.next != null && slow.next.val < x) slow = slow.next;

		LinkListNode prev = slow;
		curr = slow.next;

		while(curr != null) {

			if(curr.val < x) {
				while(curr.next != null && curr.next.val < x) curr = curr.next;

				// swap nodes
				LinkListNode temp = prev.next;
				prev.next = curr.next;
				curr.next = slow.next;
				slow.next = temp;
				slow = curr;
				curr = prev.next;
			}
			if(curr != null) curr = curr.next;
			prev = prev.next;
		}
		return dummy.next;
	}
	public static void main(String[] args) {
		M_0086_PartitionList obj = new M_0086_PartitionList();
		LinkListNode head = LinkListNode.createLinkList();
		System.out.println("processing");
		head = obj.partition(head, 3);
		LinkListNode.printLinkList(head);
	}
}
