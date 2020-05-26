package Medium;
/*
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */
import Easy.*;
import Helper.LinkListNode;
import Helper.LinkListNode;
public class M_0019_RemoveNthNodeFromEndOfList {

	// one pass
	public LinkListNode removeNthFromEnd(LinkListNode head, int n) {
		LinkListNode dummy = new LinkListNode(0);
		dummy.next = head;
        LinkListNode slow = dummy;
        LinkListNode fast = dummy;
        
        int count = 0;
        // Advances fast pointer so that the gap between slow and fast is n nodes apart
        while(fast != null && count != n+1){
        	fast = fast.next;
            count++;
        }  
        while(fast != null) {
        	slow = slow.next;
        	fast = fast.next;
        }
        slow.next = slow.next.next;	
        return dummy.next;
    }
	
	public LinkListNode removeNthFromEndApproach2(LinkListNode head, int n) {
        LinkListNode ptr = head;
        int len = 0;
        while(ptr != null){
            ptr = ptr.next;
            len++;
        }
        
        int count = len-n-1;
        ptr = head;
        while(count > 0){
            ptr = ptr.next;
            count--;
        }
        if(count == -1) head = head.next;
        else ptr.next = ptr.next.next;
        return head;
    }
	
	public static void main(String[] args) {
		M_0019_RemoveNthNodeFromEndOfList obj = new M_0019_RemoveNthNodeFromEndOfList();
		LinkListNode head = null;
		head = LinkListNode.createLinkList();
		head = obj.removeNthFromEnd(head, 5);
		LinkListNode.printLinkList(head);
	}
}
