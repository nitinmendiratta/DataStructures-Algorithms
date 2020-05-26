package Medium;
import Easy.*;
import Helper.LinkListNode;
import Helper.LinkListNode;
/*
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 * Given a linked list, swap every two adjacent nodes and return its head.
You may not modify the values in the list's nodes, only nodes itself may be changed.
Example:

Given 1->2->3->4, you should return the list as 2->1->4->3.
 */
public class M_0024_SwapNodesInPairs {

	public LinkListNode swapPairs(LinkListNode head) {
		if(head == null || head.next == null) return head;
        LinkListNode ptr = new LinkListNode(0);
        LinkListNode prev = ptr;
        LinkListNode curr = head;
        LinkListNode next = curr.next;

        
        
		while(next != null) {
			prev.next = next;
			curr.next = next.next;
			next.next = curr;
			
			
			prev = curr;
			curr = curr.next;
			if(curr == null) break;
			next = curr.next;
		}
		return ptr.next;
    }
	
	public LinkListNode swapPairsRecursive(LinkListNode head) {
        if ((head == null)||(head.next == null))
            return head;
        LinkListNode next = head.next;
        head.next = swapPairs(head.next.next);
        next.next = head;
        return next;
    }
	public static void main(String[] args) {
		M_0024_SwapNodesInPairs obj = new M_0024_SwapNodesInPairs();
		LinkListNode head = null;
		head = LinkListNode.createLinkList();
		head = obj.swapPairs(head);
		LinkListNode.printLinkList(head);
	}
}
