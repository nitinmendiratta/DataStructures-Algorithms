package Medium;
import Helper.LinkListNode;
import Helper.LinkListNode;

/* https://leetcode.com/problems/add-two-numbers/
 * Time complexity : O(max(m, n)). Assume that mm and nn represents the length of l1l1 and l2l2 respectively, the algorithm above iterates at most max(m, n)times.
 * Space complexity : O(max(m,n)). The length of the new list is at most max(m,n) + 1.
 */

public class M_0002_AddTwoNumbers {

	public LinkListNode addTwoNumbers(LinkListNode l1, LinkListNode l2) {
		LinkListNode res = new LinkListNode(-1), curr = res;
		int sum = 0;
		while (l1 != null || l2 != null || sum >= 10) {
			// get the previous carry (1 in 18)
			sum = sum / 10;
			
			if(l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            // get the remainder node (8 in 18)
			curr.next = new LinkListNode(sum % 10);
			curr = curr.next;
		}
		return res.next;
	}

	public static void main(String[] args) {
		M_0002_AddTwoNumbers obj = new M_0002_AddTwoNumbers();
		// create a linked list
		LinkListNode head1 = LinkListNode.createLinkList();
		LinkListNode head2 = LinkListNode.createLinkList();
		System.out.println("List1 is:");
		LinkListNode.printLinkList(head1);
		System.out.println("List2 is:");
		LinkListNode.printLinkList(head2);
		LinkListNode result = obj.addTwoNumbers(head1,head2);
		System.out.println("result is:");
		LinkListNode.printLinkList(result);
	}

}
