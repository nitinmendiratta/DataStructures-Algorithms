package Easy;

import Helper.LinkListNode;
import Helper.LinkListNode;

/*
 * https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
 */
public class E_1290_ConvertBinaryNumberLLtoInt {

	public int getDecimalValue(LinkListNode head) {
		// Initialize result  
		int res = 0;  

		// Traverse linked list  
		while (head != null) {  
			// shift bit to accomodate value and add head's data  
			res = (res << 1) | head.val;  

			// Move next  
			head = head.next;  
		}  
		return res; 
	}
	public static void main(String[] args) {
		E_1290_ConvertBinaryNumberLLtoInt obj = new E_1290_ConvertBinaryNumberLLtoInt();
		LinkListNode head = null;
		head = LinkListNode.createLinkList();
		System.out.println(obj.getDecimalValue(head));
	}

}
