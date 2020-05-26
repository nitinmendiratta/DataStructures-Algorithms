package Easy;
import java.util.*;

import Helper.LinkListNode;
import Helper.LinkListNode;
/*
 * https://leetcode.com/problems/merge-k-sorted-lists/
 * http://www.programcreek.com/2013/02/leetcode-merge-k-sorted-lists-java/
 */
public class E_0023_MergekSortedLists {

	public LinkListNode mergeKLists(LinkListNode[] lists) {
        if (lists.length == 0)
			return null;

		//PriorityQueue is a sorted queue
		PriorityQueue<LinkListNode> q = new PriorityQueue<LinkListNode>(lists.length, new Comparator<LinkListNode>() {
			public int compare(LinkListNode a, LinkListNode b) {
				return (a.val - b.val);
			}
		});

		//add first node of each list to the queue
		for (LinkListNode list : lists) {
			if (list != null)
				q.add(list);//there is only first node of each list not the whole list
		}

		LinkListNode head = new LinkListNode(0);
		LinkListNode p = head; // serve as a pointer/cursor

		while (q.size() > 0) {
			LinkListNode temp = q.poll();
			//poll() retrieves and removes the head of the queue - q. 
			p.next = temp;

			// takes out one elem each time and inserts the next lem in the queue, keep adding next element of each list
			if (temp.next != null){
				q.add(temp.next);
			}
			p = p.next;
		}
		return head.next;
    }

	public static void main(String[] args) {
		E_0023_MergekSortedLists obj = new E_0023_MergekSortedLists();
		LinkListNode list1 = LinkListNode.createLinkList();
		LinkListNode list2 = LinkListNode.createLinkList();
		LinkListNode list3 = LinkListNode.createLinkList();
		//ListNode[] lists = [list1, list2, list3];
		//ListNode result = obj.mergeKLists(lists);	
		//op.printLinkList(result);
	}
}
