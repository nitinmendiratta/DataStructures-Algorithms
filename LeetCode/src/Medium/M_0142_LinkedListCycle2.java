package Medium;
import Helper.*;
/*
 * https://leetcode.com/problems/linked-list-cycle-ii/
 */
public class M_0142_LinkedListCycle2 {

	/*
	 * When fast and slow meet at point p, the length they have run are 'a+2b+c' and
	 * 'a+b'. Since the fast is 2 times faster than the slow. So a+2b+c == 2(a+b),
	 * then we get 'a==c'. So when another slow2 pointer run from head to 'q', at
	 * the same time, previous slow pointer will run from 'p' to 'q', so they meet
	 * at the pointer 'q' together.
	 * https://leetcode.com/problems/linked-list-cycle-ii/discuss/44774/Java-O(1)-space-solution-with-detailed-explanation.
	 */
	public LinkListNode detectCycle(LinkListNode head) {
		LinkListNode slow = head;
		LinkListNode fast = head;

		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;

			if (fast == slow) {
				LinkListNode slow2 = head;
				while (slow2 != slow) {
					slow = slow.next;
					slow2 = slow2.next;
				}
				return slow;
			}
		}
		return null;
	}

	public static void main(String[] args) {
		M_0142_LinkedListCycle2 obj = new M_0142_LinkedListCycle2();
		LinkListNode node = LinkListNode.createCLL();
		System.out.println(obj.detectCycle(node).val);
	}
}
