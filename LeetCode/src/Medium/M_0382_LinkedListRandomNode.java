package Medium;

import java.util.*;

import Helper.LinkListNode;

/*
 * https://leetcode.com/problems/linked-list-random-node/
 */
public class M_0382_LinkedListRandomNode {

	private List<Integer> list;

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public M_0382_LinkedListRandomNode(LinkListNode head) {
        list = new ArrayList<>();
        
        while(head != null) {
            list.add(head.val);
            head = head.next;
        }
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }
    
    /* Follow up question if we have infinite stream of LL: reservior sampling
     * 
		LinkListNode head;
		Random random;
	
		public M_0382_LinkedListRandomNode(LinkListNode h) {
			head = h;
			random = new Random();
		}
	
		public int getRandom() {
	
			LinkListNode c = head;
			int r = c.val;
			for (int i = 1; c.next != null; i++) {
	
				c = c.next;
				if (random.nextInt(i + 1) == i)
					r = c.val;
			}
	
			return r;
		}
	*/

	public static void main(String[] args) {
		M_0382_LinkedListRandomNode obj = new M_0382_LinkedListRandomNode(LinkListNode.createLinkList());
		System.out.println(obj.getRandom());
	}
}
