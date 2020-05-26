package Medium;
import java.util.*;
import Helper.*;
/*
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 */
public class M_0138_CopyListRandomPointer {

	/*
	 * The algorithm is composed of the follow three steps which are also 3
	 * iteration rounds.
	 * 
	 * 1. Iterate the original list and duplicate each node. The duplicate of each node
	 * 		follows its original immediately. 
	 * 2. Iterate the new list and assign the random
	 * pointer for each duplicated node. 
	 * 3. Restore the original list and extract the
	 * 	duplicated nodes.
	 */
	// O(n) no extra space
	public LinkListNode copyRandomList(LinkListNode head) {
		LinkListNode iter = head, next;

		// First round: make copy of each node,
		// and link them together side-by-side in a single list.
		while (iter != null) {
			next = iter.next;

			LinkListNode copy = new LinkListNode(iter.val);
			iter.next = copy;
			copy.next = next;

			iter = next;
		}

		// Second round: assign random pointers for the copy nodes.
		iter = head;
		while (iter != null) {
			if (iter.random != null) {
				iter.next.random = iter.random.next;
			}
			iter = iter.next.next;
		}

		// Third round: restore the original list, and extract the copy list.
		iter = head;
		LinkListNode pseudoHead = new LinkListNode(0);
		LinkListNode copy, copyIter = pseudoHead;

		while (iter != null) {
			next = iter.next.next;

			// extract the copy
			copy = iter.next;
			copyIter.next = copy;
			copyIter = copy;

			// restore the original list
			iter.next = next;

			iter = next;
		}

		return pseudoHead.next;
	}

	// O(n) , extra space
	public LinkListNode copyRandomListApproach2(LinkListNode head) {
		if (head == null)
			return null;

		Map<LinkListNode, LinkListNode> map = new HashMap<LinkListNode, LinkListNode>();

		// loop 1. copy all the nodes
		LinkListNode oldListPtr = head;
		while (oldListPtr != null) {
			// oldNode --> newNode mapping
			map.put(oldListPtr, new LinkListNode(oldListPtr.val));
			oldListPtr = oldListPtr.next;
		}

		// loop 2. assign next and random pointers
		oldListPtr = head;
		while (oldListPtr != null) {
			LinkListNode newNode = map.get(oldListPtr);
			newNode.next = map.get(oldListPtr.next);
			newNode.random = map.get(oldListPtr.random);
			oldListPtr = oldListPtr.next;
		}

		return map.get(head);
	}

	public static void main(String[] args) {
		M_0138_CopyListRandomPointer obj = new M_0138_CopyListRandomPointer();
		LinkListNode head = LinkListNode.createLinkList();
		LinkListNode newHead = obj.copyRandomList(head);
		LinkListNode.printLinkList(newHead);
	}
}
