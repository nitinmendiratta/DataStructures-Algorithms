package Easy;

import Helper.LinkListNode;
import Helper.LinkListNode;

public class E_0141_LinkedListCycle {

	// Time Complexity: O(n),	Auxiliary Space: O(1)
	public boolean hasCycle(LinkListNode head){
		LinkListNode fast = head;
		LinkListNode slow = head;
		
		while(slow != null && fast != null && fast.next != null){
			fast = fast.next.next;
			slow = slow.next;
			if(fast == slow){
				return true;//fast.data;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		E_0141_LinkedListCycle obj = new E_0141_LinkedListCycle();
		LinkListNode head = null;
		head = LinkListNode.createCLL();
		System.out.println("There is a loop:"+obj.hasCycle(head));
	}

}
